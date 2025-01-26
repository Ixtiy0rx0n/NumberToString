package org.example;

import java.util.Scanner;

public class Main {
    private static final String[] birlik = {"", "bir", "ikki", "uch", "to'rt", "besh", "olti", "yetti", "sakkiz", "to'qqiz"};
    private static final String[] onlik = {"", "o'n", "yigirma", "o'ttiz", "qirq", "ellik", "oltmish", "yetmish", "sakson", "to'qson"};
    private static final String yuzlik = "yuz";
    private static final String[] minglik = {"", "ming", "million", "milliard", "trillion", "kvadrilyon", "kvintilyon"};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Sonni kiriting: ");
        String inputNumber = scanner.nextLine().trim();

        try {
            if (inputNumber.startsWith("-")) {
                System.out.println("Minus " + convert(inputNumber.substring(1)));
            } else if (inputNumber.equals("0")) {
                System.out.println("nol");
            } else {
                System.out.println(convert(inputNumber));
            }
        } catch (NumberFormatException e) {
            System.out.println("Noto'g'ri formatda son kiritildi.");
        }

        scanner.close();
    }

    private static String uchXona(String number) {
        int num = Integer.parseInt(number); // Kichik bo'limni raqam sifatida o'qish
        if (num == 0) return ""; // Agar faqat nol bo'lsa, bo'sh qaytariladi

        StringBuilder result = new StringBuilder();
        if (number.length() == 3 && number.charAt(0) != '0') {
            result.append(birlik[number.charAt(0) - '0']).append(" ").append(yuzlik).append(" ");
        }

        if (number.length() >= 2 && number.charAt(number.length() - 2) != '0') {
            result.append(onlik[number.charAt(number.length() - 2) - '0']).append(" ");
        }

        if (number.charAt(number.length() - 1) != '0') {
            result.append(birlik[number.charAt(number.length() - 1) - '0']);
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
                String uchXonaText = uchXona(uchlik);
                if (!uchXonaText.isEmpty()) {
                    if (i > 0) {
                        result.insert(0, minglik[i] + " ");
                    }
                    result.insert(0, uchXonaText + " ");
                }
            }
            length -= 3;
            i++;
        }
        return result.toString().trim();
    }
}
