package lotto;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {
    private static final int NUM_OF_LOTTO_NUM = 6;
    private final List<LottoNumber> lottoNumbers;

    private Lotto(List<LottoNumber> lottoNumbers) {
        validateLottoNumbers(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto create() {
        List<LottoNumber> shuffledNumbers = LottoNumber.NUM_RANGE
                .stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());

        Collections.shuffle(shuffledNumbers);

        List<LottoNumber> selectedNums = shuffledNumbers.stream()
                .limit(NUM_OF_LOTTO_NUM)
                .sorted()
                .collect(Collectors.toList());

        return new Lotto(selectedNums);
    }

    public String toString() {
        return lottoNumbers.stream()
                .map(LottoNumber::getNumber)
                .collect(Collectors.toList())
                .toString();
    }

    private void validateLottoNumbers(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != NUM_OF_LOTTO_NUM) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
    }
}
