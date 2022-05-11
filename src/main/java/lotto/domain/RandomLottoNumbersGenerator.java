package lotto.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RandomLottoNumbersGenerator {
    public static List<LottoNumber> generate() {
        Set<LottoNumber> randomLottoNumbers = new HashSet<>();
        while (randomLottoNumbers.size() < LottoNumbers.LOTTO_SIZE) {
            LottoNumber randomLottoNumber = LottoPot.getOneRandomLottoNumber();
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
