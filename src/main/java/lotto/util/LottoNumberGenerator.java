package lotto.util;

import lotto.domain.LottoNumber;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberGenerator {
    private static final int LOTTO_PICK_COUNT = 6;
    private static final List<LottoNumber> ALL_LOTTO_NUMBERS;

    static {
        ALL_LOTTO_NUMBERS = IntStream.rangeClosed(LottoNumber.MIN_NUMBER, LottoNumber.MAX_NUMBER)
            .mapToObj(LottoNumber::new)
            .collect(Collectors.toUnmodifiableList());
    }

    public static List<LottoNumber> shuffleAndPickLottoNumbers() {
        final List<LottoNumber> pickedNumbers = pickLottoNumbers(shuffle());
        Collections.sort(pickedNumbers);
        return Collections.unmodifiableList(pickedNumbers);
    }

    private static List<LottoNumber> pickLottoNumbers(final List<LottoNumber> shuffledLottoNumbers) {
        return shuffledLottoNumbers.subList(0, LOTTO_PICK_COUNT);
    }

    private static List<LottoNumber> shuffle() {
        final List<LottoNumber> shuffledLottoNumbers = new ArrayList<>(ALL_LOTTO_NUMBERS);
        Collections.shuffle(shuffledLottoNumbers);
        return shuffledLottoNumbers;
    }
}
