package lotto.ui;

import lotto.service.model.LottoNumbers;
import lotto.service.value.LottoPrice;
import lotto.utils.InputUtils;
import lotto.validator.LottoValidator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.rule.LottoRule.MINIMUM_NUMBER;

public class InputView {
    private static final String LOTTO_NUMBER_DELIMITER = ", ";

    public LottoPrice inputPurchasePrice() {
        Integer purchasePrice = InputUtils.inputToInteger("구입금액을 입력해 주세요.");
        LottoValidator.checkMinimumPurchasePrice(purchasePrice);
        LottoValidator.checkMaximumPurchasePrice(purchasePrice);
        return LottoPrice.from(purchasePrice);
    }

    public Integer inputManualCount() {
        Integer manualCount = InputUtils.inputToInteger("수동으로 구매할 로또 수를 입력해 주세요.");
        LottoValidator.checkMinimumCount(manualCount);
        return manualCount;
    }

    public List<LottoNumbers> inputManualLottoNumbers(Integer manualLottoCount) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");

        List<LottoNumbers> lottoNumbersList = new ArrayList<>();
        IntStream.rangeClosed(MINIMUM_NUMBER, manualLottoCount)
                .forEach(v -> {
                    LottoNumbers lottoNumbers = LottoNumbers.from(inputLottoNumber(InputUtils.input()));
                    lottoNumbersList.add(lottoNumbers);
                });
        return lottoNumbersList;
    }

    public List<Integer> inputWinningLottoNumberOfLastWeeks() {
        String winningNumber = InputUtils.input("지난 주 당첨 번호를 입력해 주세요.");
        return inputLottoNumber(winningNumber);
    }

    public Integer inputBonusNumber() {
        String bonusNumberString = InputUtils.input("보너스 볼을 입력해 주세요.");
        Integer bonusNumber = Integer.parseInt(bonusNumberString);

        LottoValidator.checkManualNumber(bonusNumber);
        return bonusNumber;
    }

    private List<Integer> inputLottoNumber(String lottoNumber) {
        String[] lottoNumbers = lottoNumber.split(LOTTO_NUMBER_DELIMITER);

        LottoValidator.checkLottoNumberCount((int) Arrays.stream(lottoNumbers).distinct().count());
        return Arrays.stream(lottoNumbers)
                .map(Integer::valueOf)
                .filter(LottoValidator::checkManualNumber)
                .collect(Collectors.toList());
    }
}
