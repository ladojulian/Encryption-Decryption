import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Converter {

    /**
     * It returns a double value or 0 if an exception occurred
     */
    public static double convertStringToDouble(String input) {
        try {
            return Double.parseDouble(input);
        } catch (Exception e) {
            return 0;
        }
    }
}


class Main {
    public static void main(String[] args) throws FileNotFoundException {
        countNumbersInAFile();
        sumNumbersInAFile();
        findLargestIncrease();
        countEvenNumbers();
        findTheGreatestNumberInAFile();
    }

    /**
     * Reading files  Count numbers in a file
     * https://hyperskill.org/learn/step/4841
     */
    public static void countNumbersInAFile() throws FileNotFoundException {
        var file = new File("Problems/String to double conversion/src/dataset_91022.txt");
        var scanner = new Scanner(file);

        var count = 0;
        while (scanner.hasNextInt()) {
            if (scanner.nextInt() > 9999) {
                count++;
            }
        }
        System.out.println(count);
    }

    /**
     * Reading files  The sum of numbers in a file
     * https://hyperskill.org/learn/step/4840
     */
    public static void sumNumbersInAFile() throws FileNotFoundException {
        var file = new File("Problems/String to double conversion/src/dataset_91033.txt");
        var scanner = new Scanner(file);

        var sum = 0;
        while (scanner.hasNextInt()) {
            sum += scanner.nextInt();
        }
        System.out.println(sum);
    }

    /**
     * Reading files  World population
     * https://hyperskill.org/learn/step/4838
     */
    public static void findLargestIncrease() throws FileNotFoundException {
        var file = new File("Problems/String to double conversion/src/dataset_91069.txt");
        var scanner = new Scanner(file);

        var largestIncreaseYear = 0;
        var previousPopulation = 0L;
        var diffPopulation = 0L;
        scanner.nextLine();
        while (scanner.hasNextLine()) {
            var year = scanner.nextInt();
            var pop = scanner.nextLong();

            if (previousPopulation != 0 && pop - previousPopulation > diffPopulation) {
                largestIncreaseYear = year;
                diffPopulation = pop - previousPopulation;
            }
            previousPopulation = pop;
        }
        System.out.println(largestIncreaseYear);
    }

    /**
     * Reading files  Count even numbers
     * https://hyperskill.org/learn/step/4839
     */
    public static void countEvenNumbers() throws FileNotFoundException {
        var file = new File("Problems/String to double conversion/src/dataset_91065.txt");
        var scanner = new Scanner(file);

        var count = 0;
        while (scanner.hasNextLine()) {
            var number = scanner.nextInt();

            if (number == 0) {
                break;
            }
            if (number % 2 == 0) {
                count++;
            }
        }
        System.out.println(count);
    }

    /**
     * Reading files  Find the greatest number in a file
     * https://hyperskill.org/learn/step/4842
     */
    public static void findTheGreatestNumberInAFile() throws FileNotFoundException {
        var file = new File("Problems/String to double conversion/src/dataset_91007.txt");
        var scanner = new Scanner(file);

        var greatest = Integer.MIN_VALUE;
        while (scanner.hasNextLine()) {
            var number = scanner.nextInt();
            greatest = Math.max(number, greatest);
        }
        System.out.println(greatest);
    }
}