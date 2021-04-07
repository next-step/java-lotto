package step4;

import step4.domain.count.PassiveCount;
import step4.domain.lotto.Lotto;
import step4.domain.money.Money;
import step4.domain.shop.LottoShop;
import step4.domain.winning.WinningCheckMachine;
import step4.strategy.LottoRandomShuffleStrategy;
import step4.strategy.LottoShuffleStrategy;
import step4.view.InputView;
import step4.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public final class LottoApplication {
    private static final InputView INPUT_VIEW = InputView.getInstance();
    private static final ResultView RESULT_VIEW = ResultView.getInstance();

    private static final LottoShuffleStrategy STRATEGY = LottoRandomShuffleStrategy.getInstance();

    public static void main(String[] args) {
        Money money = getInputMoney();
        PassiveCount count = getPassiveCount(money);

        InputView.printInputPassiveLotto();
        List<Lotto> lottos = new ArrayList<>();
        while (lottos.size() < count.getCount()) {
            lottos.add(getPassiveLotto());
        }

        int availablePurchaseCount = money.availablePurchaseCount(Lotto.AMOUNT, count);
        LottoShop lottoShop = LottoShop.getInstance();
        lottos.addAll(lottoShop.purchaseLotto(availablePurchaseCount, STRATEGY));
        RESULT_VIEW.printLottoList(lottos);

        WinningCheckMachine winningCheckMachine = WinningCheckMachine.getInstance();
    }

    private static Lotto getPassiveLotto() {
        try {
            return Lotto.of(INPUT_VIEW.inputPassiveLottoByClient());
        } catch (Exception e) {
            System.out.println(e.getMessage()+"\n다시 입력해주세요");
            return getPassiveLotto();
        }
    }

    private static PassiveCount getPassiveCount(Money money) {
        try {
            return getPassiveCountWithValidate(money);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getPassiveCount(money);
        }
    }

    private static final PassiveCount getPassiveCountWithValidate(Money money) {
        int count = INPUT_VIEW.inputPassiveCountByClient();
        validateCount(money, count);
        return PassiveCount.valueOf(count);
    }

    private static final void validateCount(Money money, int count) {
        if (money.isNotAvailablePurchase(Lotto.AMOUNT, count)) {
            throw new IllegalArgumentException("숫자를 잘못 입력했습니다.");
        }
    }

    private static final Money getInputMoney() {
        try {
            return Money.valueOf(INPUT_VIEW.inputMoneyByClient());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getInputMoney();
        }
    }
}
