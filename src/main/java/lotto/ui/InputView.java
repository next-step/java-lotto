package lotto.ui;

import lotto.service.value.LottoPrice;
import lotto.utils.InputUtils;
import lotto.validator.LottoValidator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final String DELIMITER = ", ";

    public LottoPrice inputPurchasePrice() {
        Integer purchasePrice = InputUtils.inputInt("구입금액을 입력해 주세요.");
        LottoValidator.checkMinimumPurchasePrice(purchasePrice);
        LottoValidator.checkMaximumPurchasePrice(purchasePrice);
        return LottoPrice.from(purchasePrice);
    }

    public List<Integer> inputLastWeeksWinningNumber() {
        String winningNumber = InputUtils.inputString("지난 주 당첨 번호를 입력해 주세요.");
        String[] winningNumbers = winningNumber.split(DELIMITER);

        LottoValidator.checkLottoNumberCount(winningNumbers.length);

        return Arrays.stream(winningNumbers)
                .map(Integer::valueOf)
                .filter(LottoValidator::checkManualNumber)
                .collect(Collectors.toList());
    }
}
