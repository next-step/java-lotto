package ui;

import lotto.*;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
        return new LottoNumbers(LottoInputUtils.toNumberList(InputScanner.inputToString()));
    }

    private static Lottos buyLottos(Money money) {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int manualLottoCount = InputScanner.inputToInt();

        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<LottoNumberStrategy> manulLottos = IntStream.range(0, manualLottoCount)
                .mapToObj(it -> new ManualLottoNumberStrategy(LottoInputUtils.toNumberList(InputScanner.inputToString())))
                .collect(Collectors.toList());

        Lottos lottos = LottoSeller.sell(new BuyLotto(money, manulLottos));
        int total = lottos.count();
        System.out.println(String.format("수동으로 %d장, 자동으로 %d개를 구매했습니다.", manualLottoCount, (total = manualLottoCount)));
        VIEWER.printLottoNumbers(lottos);

        return lottos;
    }

}
