/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package arrays;

import java.util.Arrays;
import java.util.Scanner;

public class DSAms1 {

    public static void main(String[] args) {
        Scanner strScanner = new Scanner(System.in);
        Scanner intScanner = new Scanner(System.in);

        System.out.print("Enter the number of stocks: ");
        int number = intScanner.nextInt();

        // Implementation of 2D String Array
        String[][] stockInfo = new String[number][4];

        // Input stock information to the 2D Array
        for (int i = 0; i < number; i++) {
            System.out.print("Enter brand for stock " + (i + 1) + ": ");
            stockInfo[i][0] = strScanner.nextLine();
            System.out.print("Enter engine number for stock " + (i + 1) + ": ");
            stockInfo[i][1] = strScanner.nextLine();
            System.out.print("Enter label status of stock " + (i + 1) + ": ");
            stockInfo[i][2] = strScanner.nextLine();
            System.out.print("Enter purchase status of stock " + (i + 1) + ": ");
            stockInfo[i][3] = strScanner.nextLine();
        }

        // Print values of the stockInfo Array (unsorted)
        System.out.println("\nUnsorted Values");
        printStockInfo(stockInfo);

        // Sort stockInfo array according to brand
        System.out.println("\nSorted Values according to Brand");
        stockInfo = sortStockInfo(stockInfo);
        printStockInfo(stockInfo);

        boolean searchActive = true;
        while (searchActive) {
            // Prompt the user for the search criteria
            System.out.println("\nWhat would you like to search for?");
            System.out.println("1. Brand");
            System.out.println("2. Engine Number");
            System.out.println("3. Label Status");
            System.out.println("4. Purchase Status");
            System.out.println("5. Exit");

            Scanner srchscanner = new Scanner(System.in);
            int searchChoice = srchscanner.nextInt();

            switch (searchChoice) {
                case 1:
                    // Search by brand
                    System.out.print("Enter the brand to search for: ");
                    String searchBrand = strScanner.next();
                    searchStockByBrand(stockInfo, searchBrand);
                    break;
                case 2:
                    // Search by engine number
                    System.out.print("Enter the engine number to search for: ");
                    String searchEngineNumber = strScanner.next();
                    searchStockByEngineNumber(stockInfo, searchEngineNumber);
                    break;
                case 3:
                    // Search by label status
                    System.out.print("Enter the label status to search for: ");
                    String searchLabelStatus = strScanner.next();
                    searchStockByLabelStatus(stockInfo, searchLabelStatus);
                    break;
                case 4:
                    // Search by purchase status
                    System.out.print("Enter the purchase status to search for: ");
                    String searchPurchaseStatus = strScanner.next();
                    searchStockByPurchaseStatus(stockInfo, searchPurchaseStatus);
                    break;
                case 5:
                    // Exit the search mode
                    searchActive = false;
                    System.out.println("Exiting search mode.");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    // Method for printing stock information
    private static void printStockInfo(String[][] stockInfo) {
        for (int i = 0; i < stockInfo.length; i++) {
            System.out.println(stockInfo[i][0] + "\t" + stockInfo[i][1] + "\t" + stockInfo[i][2] + "\t" + stockInfo[i][3]);
        }
    }

    // Method for sorting stock information according to brand
    private static String[][] sortStockInfo(String[][] stockInfo) {
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

    // Method for searching stock information by engine number
    private static void searchStockByEngineNumber(String[][] stockInfo, String engineNumber) {
        boolean found = false;
        System.out.println("Stock found for engine number: " + engineNumber);
        for (int i = 0; i < stockInfo.length; i++) {
            if (stockInfo[i][1].equalsIgnoreCase(engineNumber)) {
                System.out.println(stockInfo[i][0] + "\t" + stockInfo[i][1] + "\t" + stockInfo[i][2] + "\t" + stockInfo[i][3]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Stock not found for engine number: " + engineNumber);
        }
    }

    // Method for searching stock information by label status
    private static void searchStockByLabelStatus(String[][] stockInfo, String labelStatus) {
        boolean found = false;
        System.out.println("Stock found for label status: " + labelStatus);
        for (int i = 0; i < stockInfo.length; i++) {
            if (stockInfo[i][2].equalsIgnoreCase(labelStatus)) {
                System.out.println(stockInfo[i][0] + "\t" + stockInfo[i][1] + "\t" + stockInfo[i][2] + "\t" + stockInfo[i][3]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Stock not found for label status: " + labelStatus);
        }
    }

    // Method for searching stock information by purchase status
    private static void searchStockByPurchaseStatus(String[][] stockInfo, String purchaseStatus) {
        boolean found = false;
        System.out.println("Stock found for purchase status: " + purchaseStatus);
        for (int i = 0; i < stockInfo.length; i++) {
            if (stockInfo[i][3].equalsIgnoreCase(purchaseStatus)) {
                System.out.println(stockInfo[i][0] + "\t" + stockInfo[i][1] + "\t" + stockInfo[i][2] + "\t" + stockInfo[i][3]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Stock not found for purchase status: " + purchaseStatus);
        }
    }
}
