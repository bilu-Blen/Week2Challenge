package me.Blen;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// initializing some  variables and objects to use
        Scanner scan = new Scanner(System.in);
        String enterValue;
        ArrayList<GroceryItem> itemsList= new ArrayList<>();
        double cost;
        int totalItems =0;
        double totalCost = 0;

        do{
            GroceryItem item = new GroceryItem();

            System.out.println( "Please enter the name of grocery item");
            String name = scan.nextLine();
            item.setName(name);

            System.out.println("Please enter the price of the grocery item");
            double priceValue= scan.nextDouble();
            item.setPrice(priceValue);
            scan.nextLine();

            /*commenting this out to work on the bonus exercise to generate a random number
            System.out.println("Please enter the quantity of the grocery item");
            int quantity =scan.nextInt()
             scan.nextLine();*/;

            Random randomNumber = new Random();
            int randomQuantity = randomNumber.nextInt(10)+1;
            item.setQuantity(randomQuantity);


            itemsList.add(item);

            System.out.println("Do you have another grocery item to enter, write yes if you do enter any key if you don't ");
            enterValue = scan.nextLine();

        }while(enterValue.equalsIgnoreCase("yes"));


        //prompting the user if they want to print the list of grocery items
        System.out.println("Do you want to print the list of grocery items. If yes enter the word 'print'");
        String enterPrint = scan.nextLine();

        if (enterPrint.equalsIgnoreCase("print")){
            System.out.println("Item Name" + "\t\t\t" + "Price " + "\t\t\t" + "Quantity" + "\t\t\t" + "Cost"  + "\n");

            for(GroceryItem num : itemsList){
                //calculating the cost of each grocery item
                cost=num.getPrice()*num.getQuantity();

                //calculating the total cost
                totalCost = cost + totalCost;

                //calculating the total amount of grocery items
                totalItems = totalItems + num.getQuantity();


                        System.out.println(num.getName() +  "\t\t" + "\t\t" + num.getPrice() + "\t\t" +"\t\t" + num.getQuantity() + "\t\t" +"\t\t"+ cost + "\n" );

            }
            System.out.println("Total Purchase Amount =" + totalCost + "\n" +
                    "Total items purchased: " + totalItems  +"\n");
            if( totalCost>20){
                System.out.println("You spent too much today... ");
            }else {
                System.out.println("Thank you for shopping at my market!");
            }

        }

    }
}
