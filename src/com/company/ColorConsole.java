package com.company;

public class ColorConsole {
    public static void println(String s) {
        println(s, Color.WHITE);
    }

    public static final String RESET = "";

    public static void print(String string, Color color) {
        switch (color) {
            case WHITE -> System.out.print("\u001B[37m");
            case RED -> System.out.print("\u001B[31m");
            case CYAN -> System.out.print("\u001B[36m");
            case GREEN -> System.out.print("\u001B[32m");
            case YELLOW -> System.out.print("\u001B[33m");
            case BLUE -> System.out.print("\u001B[34m");
            case PURPLE -> System.out.print("\u001B[35m");
            case BLACK -> System.out.print("\u001B[30m");
            default -> {
                System.out.println();
            }
        }
        System.out.print(string);
        System.out.print("\u001B[0m");
    }

    public static void println(String string, Color color) {
        print(string, color);
        System.out.println();
    }

    enum Color {
        BLACK,
        RED,
        GREEN,
        YELLOW,
        BLUE,
        PURPLE,
        CYAN,
        WHITE
    }
}
