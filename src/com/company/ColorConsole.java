package com.company;

import java.awt.*;

public class ColorConsole {
    public static final String RESET = "\u001B[0m";
    static ColorModifierBuilder colorModifierBuilder = new ColorModifierBuilder();

    public static void println(String s, Color textColor) {
        colorModifierBuilder.setTextColor(textColor);
        println(s, colorModifierBuilder.build());
    }

    public static void println(String s) {
        println(s, Color.WHITE);
    }

    public static void println(String s, String styleModifier) {
        println(s, Color.WHITE);
    }

    public static void print(String string, String styleModifier) {
        System.out.print(styleModifier);
        System.out.print(string);
    }

    public static void print(String string) {
        print(string, colorModifierBuilder.setTextColor(Color.WHITE).build());
    }

    public static class ColorModifierBuilder {
        StringBuilder bashStyleString = new StringBuilder("\033[");
        //Обязательные параметры
        private boolean isUnderlined = false;
        private boolean isBold = false;
        private boolean isItalic = false;
        private boolean isInverted = false;

        private Color backgroundColor;
        private Color fontColor;

        public ColorModifierBuilder setBackgroundColor(Color backgroundColor) {
            this.backgroundColor = backgroundColor;
            return this;
        }

        public ColorModifierBuilder setTextColor(Color fontColor) {
            this.fontColor = fontColor;
            return this;
        }

        public ColorModifierBuilder setUnderlined() {
            isUnderlined = true;
            return this;
        }

        public ColorModifierBuilder setBold() {
            isBold = true;
            return this;
        }

        public ColorModifierBuilder setItalic() {
            isItalic = true;
            return this;
        }

        public ColorModifierBuilder setInverted() {
            isInverted = true;
            return this;
        }


        //Метод с возвращающим типом Good для генерации объекта
        public String build() {
            return getColorCodeForColor();
        }

        private String getColorCodeForColor() {
            if (isBold) bashStyleString.append("01;");
            if (isItalic) bashStyleString.append("03;");
            if (isUnderlined) bashStyleString.append("04;");
            if (isInverted) bashStyleString.append("07;");
            if (fontColor != null) bashStyleString.append("38;05;").append(getCodeForColor(fontColor)).append(";");
            if (backgroundColor != null) bashStyleString.append("48;05;").append(getCodeForColor(backgroundColor));
            return bashStyleString.append("m").toString();
        }

        private int getCodeForColor(Color color) {
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
}
