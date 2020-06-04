package dev.dahye.lotto.util;

import java.text.DecimalFormat;

public class DoubleUtils {
    public static double parseDoubleSecondDigit(double number) {
        DecimalFormat form = new DecimalFormat("#.##");
        return Double.parseDouble(form.format(number));
    }
}
