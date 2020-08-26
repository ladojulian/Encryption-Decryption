package encryptdecrypt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var operation = "enc";
        var key = 0;
        var data = new char[0];
        var fileIn = "";
        var fileOut = "";
        var algorithm = "shift";
        for (var i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-mode":
                    i++;
                    operation = args[i];
                    break;
                case "-key":
                    i++;
                    key = Integer.parseInt(args[i]);
                    break;
                case "-data":
                    i++;
                    data = args[i].toCharArray();
                    break;
                case "-in":
                    i++;
                    fileIn = args[i];
                    break;
                case "-out":
                    i++;
                    fileOut = args[i];
                    break;
                case "-alg":
                    i++;
                    algorithm = args[i];
            }
        }

        if (data.length == 0 && !fileIn.isEmpty()) {
            var file = new File(fileIn);
            try {
                var scanner = new Scanner(file);
                var lines = new StringBuilder();
                while (scanner.hasNextLine()) {
                    lines.append(scanner.nextLine());
                }
                data = lines.toString().toCharArray();
            } catch (FileNotFoundException e) {
                System.out.println("Error");
                return;
            }
        }


        switch (operation) {
            case "enc":
                encrypt(data, key, fileOut, algorithm);
                break;
            case "dec":
                decrypt(data, key, fileOut, algorithm);
                break;
            default:
        }
    }

    private static void encrypt(char[] message, int key, String fileOut, String algorithm) {
        var encrypted = processMessage(message, key, algorithm);

        if (fileOut.isEmpty()) {
            System.out.println(encrypted);
        } else {
            printFile(fileOut, encrypted);
        }
    }

    private static void decrypt(char[] message, int key, String fileOut, String algorithm) {
        var decrypted = processMessage(message, -key, algorithm);
        if (fileOut.isEmpty()) {
            System.out.println(decrypted);
        } else {
            printFile(fileOut, decrypted);
        }
    }

    private static String processMessage(char[] message, int key, String algorithm) {
        var builder = new StringBuilder();

        switch (algorithm) {
            case "shift":
                final var alphabet = "abcdefghijklmnopqrstuvwxyz";
                final var alphabetDown = alphabet.toCharArray();
                final var alphabetUp = alphabet.toUpperCase().toCharArray();
                for (var ch : message) {
                    var index = Arrays.binarySearch(alphabetUp, ch);
                    if (index < 0) {
                        index = Arrays.binarySearch(alphabetDown, ch);
                        if (index >= 0) {
                            index += key;
                            while (index >= alphabetDown.length) {
                                index -= alphabetDown.length;
                            }
                            while (index < 0) {
                                index += alphabetDown.length;
                            }
                            ch = alphabetDown[index];
                        }
                    } else {
                        index += key;

                        while (index >= alphabetUp.length) {
                            index -= alphabetUp.length;
                        }
                        while (index < 0) {
                            index += alphabetUp.length;
                        }
                        ch = alphabetUp[index];
                    }

                    builder.append(ch);
                }

                return builder.toString();
            case "unicode":
                for (var ch : message) {
                    builder.append(Character.toString(ch + key));
                }
                return builder.toString();
            default:
                return "";
        }
    }

    private static void printFile(String fileOut, String message) {
        try {
            var writer = new FileWriter(fileOut);
            writer.write(message);
            writer.close();
        } catch (IOException e) {
            System.out.println("Error");
        }
    }
}
