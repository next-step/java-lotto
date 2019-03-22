package lottogame.validator;

import lottogame.domain.LottoNumber;

import java.util.Optional;
import java.util.Set;

import static lottogame.domain.LottoNumber.MAXIMUM_LOTTO_NUMBER;
import static lottogame.domain.LottoNumber.MINIMUM_LOTTO_NUMBER;
import static lottogame.domain.LottoNumberPackage.LOTTO_GAME_SIZE;

public class LottoNumberPackageValidator implements Validatable<Set<LottoNumber>> {

    @Override
    public boolean isValid(Set<LottoNumber> target) {
        return Optional.ofNullable(target)
                        .filter(set -> set.size() == LOTTO_GAME_SIZE)
                        .isPresent();
    }

    @Override
    public String getInvalidMessage() {
        return MINIMUM_LOTTO_NUMBER + "에서 " + MAXIMUM_LOTTO_NUMBER + "까지 중복없이 숫자 " + LOTTO_GAME_SIZE + "개를 입력하세요.";
    }
}