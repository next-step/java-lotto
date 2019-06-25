package lotto.domain;

import lotto.domain.generator.LottoNumbersGenerator;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by wyparks2@gmail.com on 2019-06-25
 * Blog : http://wyparks2.github.io
 * Github : http://github.com/wyparks2
 */
public class LottoNumbers {
    private List<LottoNumber> lottoNumbers;

    public LottoNumbers(LottoNumbersGenerator generator) {
        lottoNumbers = generator.generate().stream()
                .map(LottoNumber::new)
                .sorted(Comparator.comparing(LottoNumber::getNumber))
                .collect(Collectors.toList());
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }

    public LottoRank match(WinningNumbers winningNumbers) {
        long matched = lottoNumbers.stream()
                .filter(lottoNumber -> winningNumbers.contains(lottoNumber.getNumber()))
                .count();

        return LottoRank.match(matched);
    }
}
