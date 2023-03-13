package stringCalculator;

import lotto.LottoGame;

import java.util.Scanner;

public class Application {
    public static  void main(String[] args) {
        String testSum = "//!\n1000!2!3!3";
        StringCalculator calculator = new StringCalculator(testSum);
                System.out.println(testSum+"===> "+calculator.sum());
    }
}
