package step3.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
 * Lotto
 * ver. 1.0
 * 2020.05.31
 * Copyright ...
 */
public class Lotto {

    // each Lotto numbers.
    private Set<Integer> lottoNumbers;
    private int bonusNumber;

    // default 1 to LOTTO_MAX_LIMIT (45)
    private static final List<Integer> lottoGameNumbers = IntStream.rangeClosed(1, LottoNumber.LOTTO_MAX_LIMIT)
            .boxed()
            .collect(Collectors.toList());

    public Lotto(Set<Integer> lottoNumbers) {

        LottoNumber.checkLottoRules(lottoNumbers);

        this.lottoNumbers = lottoNumbers;
        this.bonusNumber = 0;

    }

    public Lotto(Set<Integer> lottoNumbers, int bonusNumber) {

        LottoNumber.checkLottoRules(lottoNumbers, bonusNumber);

        if (bonusNumber > LottoNumber.LOTTO_DRAW_BASE_NUMBER && bonusNumber > LottoNumber.LOTTO_MAX_LIMIT) {
            throw new IllegalArgumentException("Not matched range of bonus ball.");
        }

        this.lottoNumbers = lottoNumbers;
        this.bonusNumber = bonusNumber;

    }

    public static Lotto auto() {

        Collections.shuffle(lottoGameNumbers);

        // pick LOTTO_DRAW_LIMIT
        return new Lotto(new ArrayList<>(LottoNumber.drawLottoNumbers(lottoGameNumbers))
                .stream()
                .collect(Collectors.toSet()));
    }

    public static Lotto winning(String winningLotto, String bonusNumber) {

        // pick LOTTO_DRAW_LIMIT
        return new Lotto(new HashSet<>(Arrays.asList(winningLotto.split(LottoNumber.FIXED_DELIMITER)).stream()
                .map(Integer::parseInt)
                .collect(Collectors.toSet()))
                , Integer.parseInt(bonusNumber));

    }

    public Set<Integer> getNumbers() {
        return lottoNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

}
