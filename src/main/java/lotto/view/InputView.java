package lotto.view;

import lotto.controller.LottoController;
import lotto.domain.Lottos;
import lotto.domain.Statistics;

import java.util.Scanner;

public class InputView {
    public static void executeLotto() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("구매금액을 입력해 주세요.");
        String money = scanner.nextLine();

        Lottos lottos = LottoController.generateLotto(money);

        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String winnerNumber = scanner.nextLine();

        Statistics statistics = LottoController.generateStatistics(lottos, winnerNumber);
        LottoController.findRateOfReturn(money, statistics);
    }
}
