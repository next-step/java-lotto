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
    private Set<LottoNo> lottoNumbers;

    public Lotto(Set<LottoNo> lottoNumbers) {
        LottoNumber.checkLottoRules(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public Lotto(String lottoNumbers) {
        this.lottoNumbers = Arrays.asList(lottoNumbers.split(LottoNumber.FIXED_DELIMITER))
                .stream()
                .map(x -> new LottoNo(Integer.parseInt(x)))
                .collect(Collectors.collectingAndThen(Collectors.toSet(), TreeSet::new));
    }

    public Set<LottoNo> getNumbers() {
        return lottoNumbers;
    }

}
