package lotto.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RandomLottoNumbersGenerator {
    private static final int LOTTO_NUMBERS_SIZE = 6;

    public static List<LottoNumber> generate() {
        Set<LottoNumber> randomLottoNumbers = new HashSet<>();
        while (randomLottoNumbers.size() < LOTTO_NUMBERS_SIZE) {
            LottoNumber randomLottoNumber = LottoNumber.ofRandom();
            randomLottoNumbers.add(randomLottoNumber);
        }

        return sort(toList(randomLottoNumbers));
    }

    private static List<LottoNumber> toList(Set<LottoNumber> lottoNumbers) {
        return new ArrayList<>(lottoNumbers);
    }

    private static List<LottoNumber> sort(List<LottoNumber> lottoNumbers) {
        lottoNumbers.sort(Comparator.comparingInt(LottoNumber::getLottoNumber));
        return lottoNumbers;
    }

}
