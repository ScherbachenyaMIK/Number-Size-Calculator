package com.example.numbersizecalculator.util;

import java.math.BigDecimal;
import java.math.BigInteger;

public class FormatChecker {

    private static boolean isByte(String input) {
        try {
            Byte.parseByte(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isShort(String input) {
        try {
            Short.parseShort(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isInt(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isLong(String input) {
        try {
            Long.parseLong(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isBigInteger(String input) {
        try {
            new BigInteger(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isFloat(String input) {
        try {
            if (!Float.isInfinite(Float.parseFloat(input))) {
                return true;
            } else {
                throw new NumberFormatException("Too big value");
            }
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isDouble(String input) {
        try {
            if (!Double.isInfinite(Double.parseDouble(input))) {
                return true;
            } else {
                throw new NumberFormatException("Too big value");
            }
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isBigDecimal(String input) {
        try {
            new BigDecimal(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static String checkNumberType(String input) {
        if (isByte(input)) {
            return "Byte";
        } else if (isShort(input)) {
            return "Short";
        } else if (isInt(input)) {
            return "Int";
        } else if (isLong(input)) {
            return "Long";
        } else if (isBigInteger(input)) {
            return "BigInteger";
        } else if (isFloat(input)) {
            return "Float";
        } else if (isDouble(input)) {
            return "Double";
        } else if (isBigDecimal(input)) {
            return "BigDecimal";
        } else {
            return "None";
        }
    }
}
