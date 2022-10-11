package stringcalculate;

import stringcalculate.view.InputView;

import java.util.Scanner;

public class CalculateMain {
    public static void main(String[] args) {
        StringCalculator stringCalculator = new StringCalculator(InputView.askInput(new Scanner(System.in)));
        System.out.println(stringCalculator.Calculate());
    }
}
