package lotto.domain.util;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class LottoNumberGenerator implements NumberGeneratorStrategy {

    @Override
    public LottoNumbers generate() {
        List<Integer> candidateLottoNumbers = generateCandidateLottoNumbers();
        List<Integer> lottoNumbers = refineToLottoNumbers(candidateLottoNumbers);
        return LottoNumbers.ofTypeIntegerList(lottoNumbers);
    }

    private List<Integer> refineToLottoNumbers(List<Integer> rangedNumbers) {
        List<Integer> subNumbers = rangedNumbers.subList(0, LottoNumbers.LOTTO_NUMBERS_MAX_COUNT);
        Collections.sort(subNumbers);
        return subNumbers;
    }

    private List<Integer> generateCandidateLottoNumbers() {
        List<Integer> rangedNumbers = IntStream.rangeClosed(
                        LottoNumber.LOTTO_NUMBER_MINIMUM,
                        LottoNumber.LOTTO_NUMBER_MAXIMUM)
                .boxed()
                .collect(toList());
        Collections.shuffle(rangedNumbers);
        return rangedNumbers;
    }

}