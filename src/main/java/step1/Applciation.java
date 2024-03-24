package step1;

import step1.controller.StringCalculator;

public class Applciation {
    public static void main(String[] args) {
        int calculate = StringCalculator.calculate("2 + 3 ^ 4 / 2");
        System.out.println("calculate = " + calculate);
    }
}
