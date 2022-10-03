package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoAutoMaker {


    private static final List<LottoNumber> CANDIDATE_NUMBERS = IntStream.range(LottoNumber.MIN_VALUE, LottoNumber.MAX_VALUE + 1)
            .mapToObj(LottoNumber::new)
            .collect(Collectors.toList());

    private LottoAutoMaker() {
    }

    public static Lotto makeLotto() {
        Collections.shuffle(CANDIDATE_NUMBERS);
        ArrayList<LottoNumber> lottoNumbers = new ArrayList<>(CANDIDATE_NUMBERS.subList(0, Lotto.SIZE));
        return new Lotto(lottoNumbers);
    }
}
