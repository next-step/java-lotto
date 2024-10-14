package lotto.domain;

import java.util.List;

public class WinningLottoNumbers {
    private final List<Integer> lottoNumbers;

    public WinningLottoNumbers(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != LottoNumbers.LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("로또 번호 개수는 6개입니다.");
        }

        lottoNumbers.forEach(WinningLottoNumbers::validate);

        this.lottoNumbers = lottoNumbers;
    }

    private static void validate(int lottoNumber) {
        if (!LottoNumbers.LOTTO_NUMBER_SET.contains(lottoNumber)) {
            throw new IllegalArgumentException("로또 번호의 범위는 1~45까지입니다.");
        }
    }
}
