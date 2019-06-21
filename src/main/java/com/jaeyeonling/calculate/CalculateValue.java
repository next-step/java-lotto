package com.jaeyeonling.calculate;

class CalculateValue {

    private final String calculateValue;

    CalculateValue(final String calculateValue) {
        this.calculateValue = calculateValue;
    }

    String[] split(final Separator<String> separator) {
        return separator.separate(calculateValue);
    }
}
