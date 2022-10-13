package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Collections.shuffle;

public class Lotto {
    private final static int LOTTO_FIRST_NUMBER = 0;
    private final static int LOTTO_LAST_NUMBER = 6;
    private final static int COUNTS_OF_LOTTO_NUMBER = 6;

    private final List<LottoNumber> lottoNumbers;


    public Lotto(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != COUNTS_OF_LOTTO_NUMBER) {
            throw new IllegalArgumentException("로또 번호는 6자리로 이루어져 있어야 합니다.");
        }
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
        return lottoNumber().stream()
                .mapToInt(number -> winningNumber.lottoNumber().contains(number) ? 1 : 0)
                .sum();
    }

    public NavigableSet<Integer> lottoNumber() {
        return new TreeSet<>(lottoNumbers.stream()
                .mapToInt(lottoNumber -> lottoNumber.lottoNumber())
                .boxed()
                .collect(Collectors.toList()));
    }

    public List<LottoNumber> lottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }
}
