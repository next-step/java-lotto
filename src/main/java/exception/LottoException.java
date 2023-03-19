package exception;

import lotto.LottoNumber;

import java.util.List;

public class LottoException {
    public static void validate(List<LottoNumber> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("중복된 숫자가 있습니다.");
        }
        if (numbers.size() > 6) {
            throw new IllegalArgumentException("숫자가 6개보다 많습니다");
        }
    }

    public static void validateBonusNumber(List<LottoNumber> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호가 이미 있습니다");
        }
    }
}
