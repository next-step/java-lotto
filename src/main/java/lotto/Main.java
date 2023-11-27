package lotto;

import java.util.Scanner;
import lotto.controller.LottoController;

public class Main {
    public static void main(String[] args) {
        LottoController.of(new Scanner(System.in), System.out).start();
    }
}
