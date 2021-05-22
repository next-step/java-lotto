package com.step2;

public final class StringAdditionCalculator {
    public static int calculateAddition(String inputText) {
        Separator separator;

        try {
            separator = new Separator(inputText);
        } catch (IllegalArgumentException exception) {
            return 0;
        }

        NumberGroup numberGroup = new NumberGroup(separator.separate());
        return numberGroup.calculateAddition();
    }
}
