package lotto.domain;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AutoLottoGenerator implements LottoGenerator {
    @Override
    public Lotto generate() {
        return new Lotto(getSortedLottoNumbers());
    }

    private List<LottoNumber> getSortedLottoNumbers() {
        List<LottoNumber> lottoNumbers = getUnsortedLottoNumbers();
        sort(lottoNumbers);

        return lottoNumbers;
    }

    private void sort(List<LottoNumber> lottoNumbers) {
        lottoNumbers.sort(Comparator.naturalOrder());
    }

    private List<LottoNumber> getUnsortedLottoNumbers() {
        return getShuffledAllLottoNumbers().subList(0, Lotto.LOTTO_NUMBERS_SIZE);
    }

    List<LottoNumber> getAllLottoNumbers() {
        return IntStream.rangeClosed(LottoNumber.MIN_NUMBER, LottoNumber.MAX_NUMBER)
                .boxed()
                .map(LottoNumber::getInstance)
                .collect(Collectors.toList());
    }

    private List<LottoNumber> getShuffledAllLottoNumbers() {
        List<LottoNumber> allLottoNumbers = getAllLottoNumbers();
        Collections.shuffle(allLottoNumbers);

        return allLottoNumbers;
    }
}
