package step4.domain.lotto;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/*
 * Lotto
 * ver. 1.0
 * 2020.05.31
 */
public class Lotto {

    // each Lotto numbers.
    private Set<LottoNumber> lottoNumbers;

    public Lotto(Set<LottoNumber> lottoNumbers) {
        LottoNumber.checkLottoRules(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public Lotto(String lottoNumbers) {
        this.lottoNumbers = Arrays.asList(lottoNumbers.split(LottoNumber.FIXED_DELIMITER))
                .stream()
                .map(x -> LottoNumber.of(Integer.valueOf(x)))
                .limit(LottoNumber.LOTTO_DRAW_LIMIT)
                .collect(Collectors.collectingAndThen(Collectors.toSet(), TreeSet::new));
    }

    public Set<LottoNumber> getNumbers() {
        return lottoNumbers;
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

}
