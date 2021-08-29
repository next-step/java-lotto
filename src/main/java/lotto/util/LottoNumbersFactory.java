package lotto.util;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class LottoNumbersFactory {
    private static final List<Integer> lottoNumbers = IntStream
            .rangeClosed(LottoNumber.MIN_NUMBER, LottoNumber.MAX_NUMBER)
            .boxed()
            .collect(toList());

    public static LottoNumbers makeAutoLottoNumbers() {
        Collections.shuffle(lottoNumbers);
        List<LottoNumber> lottoNumbers = pickLottoNumbers();
        return new LottoNumbers(lottoNumbers);
    }

    private static List<LottoNumber> pickLottoNumbers() {
        List<Integer> randomLottoNumbers = lottoNumbers.subList(0, LottoNumbers.LOTTO_NUMBERS_SIZE);
        Collections.sort(randomLottoNumbers);
        return randomLottoNumbers
                .stream()
                .map(LottoNumber::new)
                .collect(toList());
    }
}