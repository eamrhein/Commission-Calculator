
    /**
     *  Week 3 Assignment
     *  Eric Amrhein
     *  Programing 420
     *  Vikram Chowdiah
     */
    package com.company;
    import java.math.BigDecimal;
    import java.math.RoundingMode;
    import java.util.Scanner;
    public class Employee
    {
        /* Sets defaults for calculations */
        double salary = 60000;
        double commission = 0.10;
        double bonusCommission = 0.15;
        double salesTarget = 150000;
        double bonusTime = salesTarget * 0.80;    // Incentives Kick in when 80% of the sales target is met
        String name = "";
        public BigDecimal money(double inputs)  //creats a method for Handling Money
        {
           return new BigDecimal(inputs).setScale(2,RoundingMode.HALF_EVEN); //sets scale and rounding mode
        }

        /*  --Totalcommission Method --
         *  method that takes an employee's total sales and performs
         *  calculations based on attributes set in Employee.java
         *  The calculation changes based on whether or not employees
         *  are within 80%  of the target goal
         */
        public BigDecimal Totalcommission (double totalSales)
        {

            if (totalSales < bonusTime)
            {
                double total = totalSales * this.commission;
                double Compensation = total + this.salary;
                return money(Compensation);
            }
            else if (totalSales>= bonusTime)
            {
                double total = totalSales*this.bonusCommission;
                double Compensation = total + this.salary ;
                return money(Compensation);
            }
            else
            {
                return (new BigDecimal(0));
            }

        }
        /* -- GenerateTable Method --
         *  print out a table that shows how commission would increase
         *  when an employee's total sales increases by increments of
         *  $5000
         */
        public BigDecimal GenerateTable(double totalSales)
        {
            System.out.println("Here is an Incentive table of possible commissions");
            System.out.println("[Total Sales][Total Compensation]");
            double counterEnd = (totalSales * 1.50); // loop end condition
            double counterStart = totalSales;        // counter starts at input
            while (counterStart<=counterEnd)        // loops until condition is met
            {
                if (counterStart < bonusTime)
                {
                    double commission = counterStart * this.commission;
                    double Compensation = commission + this.salary;
                    System.out.println(" $" + money(counterStart) + "      $" + money(Compensation));
                }
                else if (counterStart>= bonusTime)
                {
                    double commission = counterStart*this.bonusCommission;
                    double Compensation = commission + this.salary;
                    System.out.println(" $" + money(counterStart) + "      $" + money(Compensation));
                }
                counterStart = counterStart +5000;
            }
            return (new BigDecimal(0));
        }

        /* --Generate Input Method
         *
         */

        public double promptForSales()
        {
            Scanner input = new Scanner(System.in);  //create new Scanner object called input
            System.out.println("Please Enter the employee's name:");
            while (!input.hasNext("[A-Za-z ]+$"))
            {
                System.out.println("Please Enter Only Names");
                input.next();
            }
            this.name = input.next();
            System.out.println("Please enter your total company sales for the year:"); //One and Only User Prompt

            while (!input.hasNextDouble())
            {
                System.out.println("Please Enter Only Numbers");
                input.next();
            }

            return input.nextDouble(); //Store input for future use
        }

        public  String GenerateComp(double input)
        {
            BigDecimal AnnualComp = this.Totalcommission(input); //calls Totalcommison() Calculator method for actual calculations
            System.out.println("Your Total Annual Compensation is: $" + AnnualComp);
            System.out.println(" "); //Create a line skip for easier reading
            return " ";
        }
        public   BigDecimal GenerateComparison(double input1,double input2)
        {
            BigDecimal difference = (this.Totalcommission(input1).subtract(this.Totalcommission(input2)));
            return  difference.abs();

        }
    }

