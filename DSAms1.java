/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author DREAM PC
 */
public class DSAms1 {

    public static void main(String[] args) {
        Scanner strScanner = new Scanner (System.in);
        Scanner intScanner = new Scanner (System.in);
        
        System.out.print("Enter the number of stocks: ");
        int number = intScanner.nextInt();  //the number depends on what the user will input
        
        //implementation of 2D String Array
        String [][] stockInfo = new String [number][4];
        
        //Input stock information to the 2D Array
        for (int i = 0; i < number; i++){
            //the statements here will be executed if the condition is true
            System.out.print("Enter brand for stock " + (i + 1) + ": ");
            stockInfo[i][0] = strScanner.nextLine();
            System.out.print("Enter engine number for stock " + (i + 1) + ": ");
            stockInfo[i][1] = strScanner.nextLine();
            System.out.print("Enter label status of stock " + (i + 1) + ": ");
            stockInfo[i][2] = strScanner.nextLine();
            System.out.print("Enter purchase status of stock " + (i + 1) + ": ");
            stockInfo[i][3] = strScanner.nextLine();
            
        }
        
        //Print values of the stockInfo Array (ascending order)
        System.out.println();
        System.out.println("Unsorted Values");
        PrintStockInfo(stockInfo);
        System.out.println();
        System.out.println("Sorted Values according to Brand");
        stockInfo = SortStockInfo(stockInfo);
        PrintStockInfo(stockInfo);
        // Example usage of searchStockByBrand method
        System.out.println();
        System.out.print("Enter the brand to search for: ");
        String searchBrand = strScanner.nextLine();
        searchStockByBrand(stockInfo, searchBrand);
      
        
    }
    
    //Method for Printing Stock Information
    private static void PrintStockInfo(String[][] stockInfo) {
        for(int i = 0; i < stockInfo.length; i++) {
            System.out.println(stockInfo[i][0] + "\t" + stockInfo[i][1] + "\t" + stockInfo[i][2] + "\t" + stockInfo[i][3]);
        }
    }
    
    //Method for Sorting Stock Information according to Brand
    private static String[][] SortStockInfo(String[][] stockInfo) {
    Arrays.sort(stockInfo, (String[] firstElem, String[] secondElem) -> {
        int result = firstElem[0].compareTo(secondElem[0]);
        return result;
    });

    return stockInfo;
}

    
    // Method for searching stock information by brand
private static void searchStockByBrand(String[][] stockInfo, String brand) {
    boolean found = false;

    System.out.println("Stock found for brand: " + brand);

    for (int i = 0; i < stockInfo.length; i++) {
        if (stockInfo[i][0].equalsIgnoreCase(brand)) {
            System.out.println(stockInfo[i][0] + "\t" + stockInfo[i][1] + "\t" + stockInfo[i][2] + "\t" + stockInfo[i][3]);
            found = true;
        }
    }

    if (!found) {
        System.out.println("No stock found for brand: " + brand);
    }
}


}
