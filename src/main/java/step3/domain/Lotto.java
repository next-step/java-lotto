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

    public static final int LOTTO_MAX_LIMIT = 45;
    public static final int LOTTO_DRAW_LIMIT = 6;
    public static final int LOTTO_DRAW_BASE_NUMBER = 0;

    // each Lotto numbers.
    private Set<Integer> lottoNumbers;

    private int bonusNumber;

    // default 1 to LOTTO_MAX_LIMIT (45)
    private static final List<Integer> lottoGameNumbers = Collections.unmodifiableList(IntStream.rangeClosed(1, LOTTO_MAX_LIMIT)
            .boxed()
            .collect(Collectors.toList()));


    public Lotto(Set<Integer> lottoNumbers) {

        //lottoNumbers.sort(Integer::compareTo);

        this.lottoNumbers = lottoNumbers;
        this.bonusNumber = 0;

    }

    public Lotto(Set<Integer> lottoNumbers, int bonusNumber) {

        //lottoNumbers.sort(Integer::compareTo);

        this.lottoNumbers = lottoNumbers;
        this.bonusNumber = bonusNumber;

    }

    public static Lotto auto() {

        Collections.shuffle(lottoGameNumbers);
        // pick LOTTO_DRAW_LIMIT
        return new Lotto(new TreeSet<>(drawLottoNumbers()));
    }


    private static List<Integer> drawLottoNumbers() {
        return lottoGameNumbers.subList(LOTTO_DRAW_BASE_NUMBER, LOTTO_DRAW_LIMIT);
    }

    public Set<Integer> getNumbers() {
        return lottoNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

}
