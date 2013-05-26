
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
                double total = totalSales * this.commission;
                double Compensation = total + this.salary;
                return money(Compensation);
        }

        /* --Generate Input Method
         *
         */

        public double promptForSales()
        {
            Scanner input = new Scanner(System.in);  //create new Scanner object called input
            System.out.print("Please enter your total company sales for the year:"); //One and Only User Prompt

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
    }

