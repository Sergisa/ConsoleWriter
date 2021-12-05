package com.company;

import java.awt.*;

public class ColorConsole {
    public static final String RESET = "\u001B[0m";

    public static void println(String s) {
        println(s, Color.WHITE);
    }

    public static void print(String string, Color color) {
        System.out.print(getColorCodeForColor(color));
        System.out.print(string);
    }

    public static void println(String string, Color color) {
        print(string, color);
        System.out.println();
    }

    private static String getColorCodeForColor(Color color) {
        return getColorCodeForColor(null, color, false, false, false, false);
    }

    private static String getColorCodeForColor(Color backgroundColor, Color fontColor, boolean isBold, boolean isUnderlined, boolean isItalic, boolean isInversedColor) {
        StringBuilder colorCodeString = new StringBuilder("\033[");
        int r = 0, g = 0, b = 0;
        if (isBold) colorCodeString.append("01;");
        if (isItalic) colorCodeString.append("03;");
        if (isUnderlined) colorCodeString.append("04;");
        if (isInversedColor) colorCodeString.append("07;");
        if (fontColor != null) colorCodeString.append("38;05;").append(getCodeForColor(fontColor));
        if (backgroundColor != null) colorCodeString.append("48;05;").append(getCodeForColor(backgroundColor));
        return colorCodeString.append("m").toString();
    }

    private static int getCodeForColor(Color color) {
        float r, g, b;
        r = color.getRed();
        g = color.getGreen();
        b = color.getBlue();
        if (r == g && r == b) {
            return (int) ((r > 239) ? 15 : Math.floor(r / 10) + 232);
        }
        r = (int) (Math.floor(r / 51));
        g = (int) Math.floor(g / 51);
        b = (int) Math.floor(b / 51);

        return (int) (16 + 36 * r + 6 * g + b);
    }
}
