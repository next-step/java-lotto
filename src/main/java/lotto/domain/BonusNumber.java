package lotto.domain;

import java.util.List;

import static lotto.domain.LottoValidator.MAX_LOTTO_NUMBER;
import static lotto.domain.LottoValidator.MIN_LOTTO_NUMBER;

public class BonusNumber {
    public static final String INVALID_LOTTO_NUMBER_BOUND_MESSAGE = "로또 번호는 " + MIN_LOTTO_NUMBER + "이상 " + MAX_LOTTO_NUMBER + "이하의 숫자만 입력할 수 있습니다.";
    public static final String ALREADY_EXIST_LOTTO_NUMBER = "해당 번호는 기본 당첨 번호입니다. 다시 입력해주세요.";

    private final int value;

    private BonusNumber(int value) {
        this.value = value;
    }

    public static BonusNumber fromValidDuplicate(int value, LottoNumber winningNumber) {
        if (LottoValidator.isInvalidLottoNumberBound(value)) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_BOUND_MESSAGE);
        }
        BonusNumber bonusNumber = new BonusNumber(value);
        if (winningNumber.isContainBonusNumber(bonusNumber)) {
            throw new IllegalArgumentException(ALREADY_EXIST_LOTTO_NUMBER);
        }
        return bonusNumber;
    }

    public boolean isInLottoNumberList(List<Integer> lottoNumberList) {
        return lottoNumberList.contains(value);
    }
}
