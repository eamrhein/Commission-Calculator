/**
 *  Week 4 Assignment
 *  Eric Amrhein
 *  Programing 420
 *  Vikram Chowdiah
 */
/** todo  1. add a user interface class
 *
 *
 */
package com.company; //Package Directory, Remove if File Directories are changed
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main
{
    public static BigDecimal money(double inputs)
    {
        return new BigDecimal(inputs).setScale(2, RoundingMode.HALF_EVEN); //sets scale and rounding mode
    }


    public static void main(String[] args)
    {
        System.out.println("Welcome to Compensation Calculator");
        System.out.println("How many Employees are we looking at?");
        Scanner input = new Scanner(System.in);
        while (!input.hasNextInt())
        {
            System.out.println("Please enter only integer numbers");
            input.next();
        }
        int n = input.nextInt();

       //*h
        Employee salesman[] = new Employee[n];
        for (int k=1; k<= salesman.length;k++)
        {
            salesman[k-1] = new Employee();
        }

       for (int k = 1; salesman.length >= k; k++ )
        {
           salesman[k-1].setName((k));
           salesman[k-1].setTotalsales();
           salesman[k-1].setTotalcommission();
        }
        /** todo (add options for all three calculations) **/
        System.out.println("What calculation would you like to perform?\n" +
                "1  Compare two employees' compensation\n"
                );
        while (!input.hasNextInt())
        {
            System.out.println("Please enter only integer numbers");
            input.next();
        }
        if (!input.hasNext(Pattern.compile("[1]+$"))){
            System.out.println("That is not a valid choice");
            System.out.print("Please enter a number between 1 and x:");
            input.next();
        }
        int g = input.nextInt();
        if (g==1)
        {
            System.out.println("Pick 1 of 2 Employee's To Compare");
            for (int k = 1; salesman.length>=k;k++)
            {
                String saleName = salesman[k-1].getName();
                System.out.println( k + ". " + saleName);


            }
            int a = input.nextInt();
            System.out.println("Pick the second employee to compare.");
            int b = input.nextInt();
            salesman[a-1].setTotalcommission();
            salesman[b-1].setTotalcommission();
            double absoluteSalesDifference = Math.abs(salesman[a-1].getTotalSales() - salesman[b-1].getTotalSales());
            BigDecimal salesDiff = money(absoluteSalesDifference);
            if (salesman[a-1].getTotalCommission().compareTo(salesman[b-1].getTotalCommission())==1)
            {
                BigDecimal compareDifference = salesman[a-1].getTotalCommission().subtract(salesman[b-1].getTotalCommission());
                System.out.println(salesman[a-1].getName()+ " made $" + compareDifference +" more than " + salesman[b-1].getName());
                System.out.println(salesman[b-1].getName()+" needs to make $" + salesDiff + " more in sales to match " +salesman[a-1].getName());
            }
            if  (salesman[a-1].getTotalCommission().compareTo(salesman[b-1].getTotalCommission())==-1)
            {
                BigDecimal compareDifference = salesman[b-1].getTotalCommission().subtract(salesman[a-1].getTotalCommission());
                System.out.println(salesman[b-1].getName()+ " made $" + compareDifference +" more than " + salesman[a-1].getName());
                System.out.println(salesman[a-1].getName()+" needs to make $" + salesDiff + " in sales to match " +salesman[b-1].getName());
            }
            if (salesman[a-1].getTotalCommission().compareTo(salesman[b-1].getTotalCommission())==0)
            {
                System.out.println(salesman[a-1].getName()+" and "+ salesman[b-1].getName()+" made equal commision");
            }
        }

    }

}