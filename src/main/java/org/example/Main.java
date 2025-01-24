package org.example;
import java.util.Scanner;
public class Main {
    private static final String[] birlik = {"", "bir", "ikki", "uch", "to'rt", "besh", "olti", "yetti", "sakkiz", "to'qqiz"};
    private static final String[] onlik = {"", "o'n", "yigirma", "o'ttiz", "qirq", "ellik", "oltmish", "yetmish", "sakson", "to'qson"};
    private static final String yuzlik = "yuz";
    private static final String[] minglik = {"", "ming", "million", "milliard", "trillion", "kvadrilon", "kvintilion"};
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Sonni kiriting: ");
        String inputNumber = scanner.nextLine();

        String outputString = convert(inputNumber);
        System.out.println(outputString);

        scanner.close();
    }

    private static String uchXona(String number) {
        int count = number.length();
        StringBuilder result = new StringBuilder();

        // Yuzliklar
        if (count >= 3 && number.charAt(count - 3) != '0') {
            result.append(birlik[number.charAt(count - 3) - '0']).append(" ").append(yuzlik).append(" ");
        }

        // O'nliklar
        if (count >= 2 && number.charAt(count - 2) != '0') {
            result.append(onlik[number.charAt(count - 2) - '0']).append(" ");
        }

        // Birliklar
        if (number.charAt(count - 1) != '0') {
            result.append(birlik[number.charAt(count - 1) - '0']);
        }
        return result.toString().trim();
    }

    public static String convert(String number) {
        StringBuilder result = new StringBuilder();
        int length = number.length();
        int i = 0;

        while (length > 0) {
            String uchlik = number.substring(Math.max(0, length - 3), length);
            if (!uchlik.equals("000")) {
                if (i > 0) {
                    result.append(" ").append(minglik[i]);
                }
                result.append(" ").append(uchXona(uchlik));
            }
            length -= 3;
            i++;
        }
        return result.toString().trim();
    }
}
