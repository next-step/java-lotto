package lotto.view;

import lotto.Lotto;
import lotto.LottoMachine;

import java.util.Scanner;

public class ResultView {
    private static final String PURCHASE_MESSAGE = "%d개를 구매했습니다.\n";
    private static final Scanner SCANNER = new Scanner(System.in);

    public void printLotties(LottoMachine lottoMachine) {
        System.out.printf(PURCHASE_MESSAGE, lottoMachine.getLottoCount());
        for (int i = 0; i < lottoMachine.lottiesCount(); i++) {
            Lotto lotto = lottoMachine.getLotties().getLotties().get(i);
            System.out.println(lotto.getLottoNums().toString());
        }
    }
}
