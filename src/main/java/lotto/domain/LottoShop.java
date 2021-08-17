package lotto.domain;

import calculator.InvalidInputException;
import lotto.strategy.RandomLottoNumber;
import lotto.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class LottoShop {
    private static final String INVALID_MANUAL_QUANTITY = "수동 구매 로또 수가 전체 구입금액을 초과합니다.";
    private static final int LOTTO_PRICE = 1000;

    private static Money money;
    private static Lottos lottos;

    public LottoShop(int purchaseAmount, int manualLottoQuantity) {
        money = new Money(purchaseAmount);
        lottos = new Lottos(generateManualLotto(manualLottoQuantity), generateAutomaticLotto(getPurchaseQuantity()-manualLottoQuantity));
    }

    private List<Lotto> generateAutomaticLotto(int automaticQuantity) {
        List<Lotto> automaticLottoList = new ArrayList<>();
        for (int i = 0; i < automaticQuantity; i++) {
            automaticLottoList.add(Lotto.of(RandomLottoNumber.generateRandomNumbers()));
        }
        return automaticLottoList;
    }

    private List<Lotto> generateManualLotto(int manualLottoQuantity) {
        validateManualQuantity(manualLottoQuantity);
        if (manualLottoQuantity == 0) {
            return new ArrayList<>();
        }
        List<Lotto> manualLottoList = new ArrayList<>();
        String[] manualNumbersArray = InputView.inputManualNumbers(manualLottoQuantity);
        for (String numbers : manualNumbersArray) {
            manualLottoList.add(Lotto.of(numbers));
        }
        return manualLottoList;
    }

    private void validateManualQuantity(int manualQuantity) {
        if (manualQuantity > getPurchaseQuantity()) {
            throw new InvalidInputException(INVALID_MANUAL_QUANTITY);
        }
    }

    public static int getPurchaseQuantity() {
        return money.getPurchaseMoney() / LOTTO_PRICE;
    }

    public Lottos getLottos() {
        return lottos;
    }

    public static Money getMoney() {
        return money;
    }
}
