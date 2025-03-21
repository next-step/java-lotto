package stringcalcaulator;

import java.util.Scanner;

import stringcalcaulator.controller.StringCalcController;
import stringcalcaulator.domain.StringCalculator;

public class StringCalculatorMain {

    public static void main(String[] args) {
        new StringCalcController().run();
    }

}
