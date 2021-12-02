package com.company;

public class ColorConsole {
    public static final String RESET = "\u001B[0m";
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";

    public static void println(String s) {
        println(s, "white");
    }

    public static void print(String string, String color) {
        switch (color) {
            case "white" -> System.out.print(WHITE);
            case "red" -> System.out.print(RED);
            case "cyan" -> System.out.print(CYAN);
            case "green" -> System.out.print(GREEN);
            case "yellow" -> System.out.print(YELLOW);
            case "blue" -> System.out.print(BLUE);
            case "purple" -> System.out.print(PURPLE);
            case "black" -> System.out.print(BLACK);
            default -> {
                System.out.println();
            }
        }
        System.out.print(string);
        System.out.print(RESET);
    }

    public static void println(String string, String color) {
        print(string, color);
        System.out.println();
    }
}
