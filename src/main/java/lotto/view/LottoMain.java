package lotto.view;

import java.util.Scanner;

public class LottoMain {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        LottoManager lottoManager = new LottoManager(new InputView(), new OutputView());
        lottoManager.run();
    }
}
