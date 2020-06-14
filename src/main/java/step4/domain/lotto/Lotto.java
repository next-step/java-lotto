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
    private Set<Integer> lottoNumbers;

    public Lotto(TreeSet<Integer> lottoNumbers) {
        LottoNumber.checkLottoRules(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public Lotto(String lottoNumbers) {
        this.lottoNumbers = new TreeSet<>(Arrays.asList(lottoNumbers.split(LottoNumber.FIXED_DELIMITER)).stream()
                .map(Integer::parseInt)
                .collect(Collectors.toSet()));
    }

    public Set<Integer> getNumbers() {
        return lottoNumbers;
    }

}
