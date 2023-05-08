package lotto.view;

import lotto.controller.LottoController;

import java.util.Scanner;

public class InputView {

    public static void main(String[] args) {
        lottoExecute();
    }

    private static void lottoExecute() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("구매금액을 입력해 주세요.");
        String money = scanner.nextLine();

        LottoController.lottoGenerator(money);

        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String winnerNumber = scanner.nextLine();

        LottoController.statisticsGenerator(winnerNumber, money);
    }
}
