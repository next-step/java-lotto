package step3.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
 * Lotto
 * ver. 1.0
 * 2020.05.31
 */
public class Lotto {

    // each Lotto numbers.
    private Set<Integer> lottoNumbers;

    // default 1 to LOTTO_MAX_LIMIT (45)
    private static final List<Integer> lottoGameNumbers = IntStream.rangeClosed(1, LottoNumber.LOTTO_MAX_LIMIT)
            .boxed()
            .collect(Collectors.toList());

    public Lotto(TreeSet<Integer> lottoNumbers) {
        LottoNumber.checkLottoRules(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public Lotto(String winningLotto) {
        this.lottoNumbers = new TreeSet<>(Arrays.asList(winningLotto.split(LottoNumber.FIXED_DELIMITER)).stream()
                .map(Integer::parseInt)
                .collect(Collectors.toSet()));
    }

    public static Lotto auto() {
        Collections.shuffle(lottoGameNumbers);
        // pick LOTTO_DRAW_LIMIT
        return new Lotto(new TreeSet<>(LottoNumber.drawLottoNumbers(lottoGameNumbers)));
    }

    public Set<Integer> getNumbers() {
        return lottoNumbers;
    }

}
