package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Collections.shuffle;

public class Lotto {
    private final static int LOTTO_FIRST_NUMBER = 0;
    private final static int LOTTO_LAST_NUMBER = 6;

    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = new ArrayList<>(lottoNumbers);
    }

    public List<Lotto> issue(Payment payment) {
        return IntStream.range(0, payment.count())
                .mapToObj(i -> randomLotto())
                .collect(Collectors.toUnmodifiableList());
    }

    private Lotto randomLotto() {
        shuffle(lottoNumbers);
        return new Lotto(new ArrayList<>(lottoNumbers.subList(LOTTO_FIRST_NUMBER, LOTTO_LAST_NUMBER)));
    }

    public int compareNumber(final Lotto winningNumber) {
        return lottoNumbers().stream()
                .mapToInt(number -> winningNumber.lottoNumbers.contains(number) ? 1 : 0)
                .sum();
    }

    public List<LottoNumber> lottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }

}
