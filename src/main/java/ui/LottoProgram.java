package ui;

import lotto.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoProgram {
    private static final LottoView VIEWER = new LottoView();

    public static void main(String[] args) {

        Money money = createMoney();

        int manualLottoCount = inputManualLottoCount();
        Lottos lottos = buyLottos(manualLottoCount, money);

        VIEWER.printBoughtLottoCount(manualLottoCount, lottos.count());
        VIEWER.printLottoNumbers(lottos);

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

    private static Lottos buyLottos(int manualLottoCount, Money money) {

        Money manualLottoMoney = LottoSeller.price(manualLottoCount);
        Lottos manual = buyLotto(manualLottoMoney, manualLottoCount, createManualLottoList(manualLottoCount));

        int autoLottoCount = LottoSeller.availableLottoCount(money) - manualLottoCount;
        Lottos auto = buyLotto(money.subtract(manualLottoMoney), autoLottoCount);

        auto.merge(manual.getLottos());
        return auto;
    }

    private static Lottos buyLotto(Money money, int autoLottoCount) {
        return LottoSeller.sell(BuyAutoLotto.create(money, autoLottoCount));
    }

    private static Lottos buyLotto(Money manualLottoMoney, int manualLottoCount, List<List<Integer>> manualLottoList) {
        return LottoSeller.sell(BuyManualLotto.create(manualLottoMoney, manualLottoCount, manualLottoList));
    }


    private static List<List<Integer>> createManualLottoList(int manualLottoCount) {
        return IntStream.range(0, manualLottoCount)
                .mapToObj(it -> LottoInputUtils.toNumberList(InputScanner.inputToString()))
                .collect(Collectors.toList());
    }

    private static int inputManualLottoCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return InputScanner.inputToInt();
    }



}
