/**
 *  Week 3 Assignment
 *  Eric Amrhein
 *  Programing 420
 *  Vikram Chowdiah
 */

package com.company; //Package Directory, Remove if File Directories are changed
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main
{

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

        System.out.println("What calculation would you like to perform?\n" +
                "1. Generate An Incentive table\n" +
                "2. Compare two employees' compensation\n" +
                "3. Look at one employees total annual commission");
        while (!input.hasNextInt())
        {
            System.out.println("Please enter only integer numbers");
            input.next();
        }
        if (!input.hasNext(Pattern.compile("[123]+$"))){
            System.out.println("That is not a valid choice");
            System.out.print("Please enter a number between 1 and 3:");
            input.next();
        }
        int g = input.nextInt();
        if (g==1)
        {
            System.out.println("Which Employee do you wish to generate an incentive table for?");
            for (int k = 1; salesman.length>=k;k++)
            {
                String saleName = salesman[k-1].getName();
                System.out.println( k + ". " + saleName);

                /** todo (add options for all three calculations) **/
            }
        }

    }

}