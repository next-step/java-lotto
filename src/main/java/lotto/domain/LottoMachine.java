package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Collections.shuffle;

public class LottoMachine {

    private final static int LOTTO_FIRST_NUMBER = 0;
    private final static int LOTTO_LAST_NUMBER = 6;

    private final List<LottoNumber> lottoNumbers;

    public LottoMachine(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = new ArrayList<>(lottoNumbers);
    }

    public List<Lotto> automaticIssue(int count) {
        return IntStream.range(0, count)
                .mapToObj(i -> randomLotto())
                .collect(Collectors.toUnmodifiableList());
    }

    private Lotto randomLotto() {
        shuffle(lottoNumbers);
        return new Lotto(new ArrayList<>(lottoNumbers.subList(LOTTO_FIRST_NUMBER, LOTTO_LAST_NUMBER)));
    }
}
