package lotto.domain;

import java.util.List;
import java.util.Optional;

public class ExceptionHandler {

    public static void validLottoSize(List<Integer> lottoNumber) {
        if (lottoNumber.size() != LottoNumbers.LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 번호는 여섯개를 입력해야 합니다.");
        }
    }

    public static void validLottoNumberRange(List<Integer> lottoNumber) {
        Optional<Integer> overNumber = lottoNumber.stream()
                .filter(number -> number > LottoNumbers.MAX_LOTTO_NUMBER || number < LottoNumbers.MIN_LOTTO_NUMBER)
                .findAny();

        if(overNumber.isPresent()) {
            throw new IllegalArgumentException("로또 번호는 1이상 45 이하여야 합니다");
        }
    }
}
