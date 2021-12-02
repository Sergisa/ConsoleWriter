package com.company;

public class ColorConsole {
    public static final String RESET = "\u001B[0m";

    public static void println(String s) {
        println(s, Color.WHITE);
    }

    public static void print(String string, Color color) {
        System.out.print(color.colorCodeString);
        System.out.print(string);
    }

    public static void println(String string, Color color) {
        print(string, color);
        System.out.println();
    }

    enum Color {
        BLACK("\u001B[30m"),
        BLUE("\u001B[34m"),
        CYAN("\u001B[36m"),
        GREEN("\u001B[32m"),
        PURPLE("\u001B[35m"),
        RED("\u001B[31m"),
        WHITE("\u001B[37m"),
        YELLOW("\u001B[33m");
        
        private final String colorCodeString;

        Color(String colorCode) {
            colorCodeString = colorCode;
        }
    }
}
