package lotto;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.controller.LottoController;

public class Main {
    public static void main(String[] args) {
        LottoController.of(new Scanner(System.in), System.out).start();
    }
}
