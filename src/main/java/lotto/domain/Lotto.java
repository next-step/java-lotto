package lotto.domain;

import java.util.Set;
import java.util.stream.Collectors;

import static lotto.domain.LottoFactory.LOTTO_SIZE;

public class Lotto {

    private final Set<LottoNumber> lotto;

    public Lotto(NumbersGenerator lotto) {
        this(lotto.getNumbers());
    }

    public Lotto(Set<Integer> lotto) {
        validate(lotto);

        this.lotto = lotto.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toSet());
    }

    public Set<Integer> getLotto() {
        return lotto.stream()
                .mapToInt(LottoNumber::getNumber)
                .boxed()
                .collect(Collectors.toSet());
    }

    private Set<LottoNumber> of() {
        return lotto;
    }

    public int getMatchingCount(Lotto winningLotto) {
        return (int) lotto.stream()
                .map(LottoNumber::getNumber)
                .filter(lottoNumber -> winningLotto.getLotto().contains(lottoNumber))
                .count();
    }

    public boolean contains(LottoNumber bonusNumber) {
        return lotto.stream()
                .map(LottoNumber::getNumber)
                .anyMatch(lottoNumber -> lottoNumber == bonusNumber.getNumber());
    }

    private void validate(Set<Integer> autoLotto) {

        if (autoLotto.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
    }
}
