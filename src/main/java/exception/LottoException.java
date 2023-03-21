package exception;

import configuration.LottoConfiguration;
import lotto.Lotto;
import lotto.LottoNumber;

import java.util.List;

public class LottoException {
    public static void validate(Lotto numbers) {
        if (numbers.getLottoNumbers().size() != numbers.getLottoNumbers().stream().distinct().count()) {
            throw new IllegalArgumentException("중복된 숫자가 있습니다.");
        }
        if (numbers.getLottoNumbers().size() > 6) {
            throw new IllegalArgumentException("숫자가 6개보다 많습니다");
        }
    }

    public static void validateLottoNumber(int number) {
        if (number < LottoConfiguration.LOTTO_RANGE_MIN |
                number > LottoConfiguration.LOTTO_RANGE_MAX) {
            throw new IllegalArgumentException("로또 숫자 범위가 아닙니다");
        }
    }
    public static void validateBonusNumber(Lotto numbers, int bonusNumber) {
        if (numbers.getLottoNumbers().contains(LottoNumber.of(bonusNumber))) {
            throw new IllegalArgumentException("보너스 번호가 이미 있습니다");
        }
    }
}
