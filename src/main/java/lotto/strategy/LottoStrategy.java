package lotto.strategy;

import lotto.exception.InvalidInputException;
import lotto.domain.Lotto;
import lotto.domain.LottoShop;
import lotto.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class LottoStrategy {

    private static final String INVALID_MANUAL_QUANTITY = "수동 구매 로또 수가 전체 구입금액을 초과합니다.";

    public static int automaticQuantity;
    public static int manualLottoQuantity;

    public LottoStrategy(int manualLottoQuantity, int automaticQuantity) {
        this.manualLottoQuantity = manualLottoQuantity;
        this.automaticQuantity = automaticQuantity;
    }

    public List<Lotto> generateAutomaticLotto() {
        List<Lotto> automaticLottoList = new ArrayList<>();
        for (int i = 0; i < automaticQuantity; i++) {
            automaticLottoList.add(Lotto.of(RandomLottoNumber.generateRandomNumbers()));
        }
        return automaticLottoList;
    }

    public List<Lotto> generateManualLotto() {
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
        if (manualQuantity > LottoShop.getPurchaseQuantity()) {
            throw new InvalidInputException(INVALID_MANUAL_QUANTITY);
        }
    }

}
