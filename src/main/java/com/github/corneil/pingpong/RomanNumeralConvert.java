package com.github.corneil.pingpong;

public class RomanNumeralConvert {
    public enum Numerals {
        THOUSAND("M", 1000),
        NINE_HUNDRED("CM", 900),
        FIVE_HUNDRED("D", 500),
        FOUR_HUNDRED("CD", 400),
        HUNDRED("C", 100),
        NINETY("XC", 90),
        FIFTY("L", 50),
        FORTY("XL", 40),
        TEN("X", 10),
        NINE("IX", 9),
        FIVE("V", 5),
        FOUR("IV", 4),
        ONE("I", 1);
        private String numeral;
        private int arabic;

        Numerals(String numeral, int arabic) {
            this.numeral = numeral;
            this.arabic = arabic;
        }
    }

    public static int parse(String input) {
        for (Numerals numeral : Numerals.values()) {
            if (input.startsWith(numeral.numeral)) {
                int len = numeral.numeral.length();
                int result = numeral.arabic;
                if (input.length() > len) {
                    result += parse(input.substring(len));
                }
                return result;
            }
        }
        throw new RuntimeException("Invalid numeral:" + input);
    }

    public static String convert(int value) {
        StringBuilder result = new StringBuilder();
        int remainder = value;
        while (remainder > 0) {
            for (Numerals numeral : Numerals.values()) {
                while (remainder >= numeral.arabic) {
                    result.append(numeral.numeral);
                    remainder -= numeral.arabic;
                }
            }
        }
        return result.toString();
    }
}
