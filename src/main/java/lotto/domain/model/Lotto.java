package lotto.domain.model;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.domain.model.LottoNumber.LOWER_BOUND;
import static lotto.domain.model.LottoNumber.UPPER_BOUND;

public class Lotto {
    private static final int NUM_OF_LOTTO_NUM = 6;
    private static final List<LottoNumber> LOTTO_NUMBER_CANDIDATES = IntStream.rangeClosed(LOWER_BOUND, UPPER_BOUND)
            .mapToObj(LottoNumber::new)
            .collect(Collectors.toList());

    private final List<LottoNumber> lottoNumbers;

    private Lotto(List<LottoNumber> lottoNumbers) {
        validateLottoNumbers(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto createAuto() {
        List<LottoNumber> numbersForShuffle = new ArrayList<>(LOTTO_NUMBER_CANDIDATES);
        Collections.shuffle(numbersForShuffle);

        List<LottoNumber> selectedNums = numbersForShuffle.stream()
                .limit(NUM_OF_LOTTO_NUM)
                .sorted()
                .collect(Collectors.toList());

        return new Lotto(selectedNums);
    }

    public static Lotto createManual(List<Integer> nums) {
        List<LottoNumber> lottoNumbers = nums.stream()
                .map(LottoNumber::new)
                .distinct()
                .collect(Collectors.toList());

        return new Lotto(lottoNumbers);
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    public int calculateMatchedNum(Lotto lotto) {
        return (int) lottoNumbers.stream()
                .filter(lotto.lottoNumbers::contains)
                .count();
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
