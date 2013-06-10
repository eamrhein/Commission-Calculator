
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

        /** todo 1.(add Table Generator )
         *  todo 2. add an length roster attribute
         **/
        /* Sets defaults for calculations */
        private double salary = 60000;
        private double commission = 0.10;
        private double bonusCommission = 0.15;
        private double salesTarget = 150000;
        private double incentive = salesTarget * 0.80;    // Incentives Kick in when 80% of the sales target is met
        private String name = "Default";
        private double totalSales = 0.00;
        private BigDecimal totalCommission =  new BigDecimal(0);
        //creats a method for Handling Money
        public BigDecimal money(double inputs)
        {
            return new BigDecimal(inputs).setScale(2,RoundingMode.HALF_EVEN); //sets scale and rounding mode
        }

        /** setName Method
         *  Method to Set String
         *  Name Attribute
         **/
        public void setName(int g)
        {
            Scanner input = new Scanner(System.in);  //create new Scanner object called input
            System.out.println("Please Enter employee number " + g + "'s name:");
            while (!input.hasNext("[A-Za-z ]+$"))
            {
                System.out.println("Please Enter Only Names");
                input.next();
            }

            name = input.next();
        }


        public String getName()
        {
        return name;
        }

        public void setTotalsales()
        {
            Scanner input = new Scanner(System.in);
            System.out.println("Please enter his/her total company sales for the year:"); //One and Only User Prompt
            while (!input.hasNextDouble())
            {
                System.out.println("Please Enter Only Numbers");
                input.next();
            }

            totalSales= input.nextDouble(); //Store input for future use
        }

        public double getTotalSales()
        {
        return totalSales;
        }


        public void setTotalcommission ()
        {

            if (totalSales < incentive)
            {
                double Compensation = this.salary;
                totalCommission = money(Compensation);
            }
            else if (totalSales>= incentive)
            {
                if (totalSales >= salesTarget)
                {
                double total = totalSales*this.bonusCommission;
                double Compensation = total + this.salary ;
                totalCommission = money(Compensation);
                }
                else
                {
                    double total = totalSales*this.commission;
                    double Compensation = total + this.salary;
                    totalCommission = money(Compensation);
                }

            }
            else
            {
                totalCommission =(new BigDecimal(0));
            }

        }
        public BigDecimal getTotalCommission(){
            return totalCommission;
        }

    }

