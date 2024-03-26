package ui;

import lotto.*;

import java.util.Scanner;

public class LottoProgram {
    private static final LottoView VIEWER = new LottoView();

    public static void main(String[] args) {

        Money money = createMoney();
        Lottos lottos = buyLottos(money);
        LottoNumbers winNums = createWinLottoNumbers();
        BonusNumber bonusNumber = createBonusNumber();

        LottoSummary summary = new LottoResult(lottos.getRanks(winNums, bonusNumber), money).toLottoSummary();
        VIEWER.printLottoSummary(summary);
    }

    private static Money createMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return new Money(InputScanner.inputToInt());
    }

    private static BonusNumber createBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return new BonusNumber(InputScanner.inputToInt());
    }

    private static LottoNumbers createWinLottoNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return new LottoNumbers( InputScanner.inputToString());
    }

    private static Lottos buyLottos(Money money) {
        Lottos lottos = LottoSeller.sell(money, new RandomLottoNumberStrategy());
        System.out.println(String.format("%d를 구매했습니다", lottos.count()));

        VIEWER.printLottoNumbers(lottos);

        return lottos;
    }

}
