package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;

public class Lotto {
    public static final int LOTTO_NUMBERS_SIZE = 6;

    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<Integer> lottoNumbers) {
        validateSize(lottoNumbers);
        validateDuplicate(lottoNumbers);

        this.lottoNumbers = lottoNumbers.stream()
                .map(num -> new LottoNumber(num))
                .collect(toList());
    }

    public List<LottoNumber> getNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }

    public Rank match(Lotto winningLotto, int bonusNumber) {
        return Rank.of(match(winningLotto), contains(new LottoNumber(bonusNumber)));
    }

    public int match(Lotto winningLotto) {
        return (int) lottoNumbers.stream()
                .filter(num -> winningLotto.contains(num))
                .count();
    }

    private boolean contains(LottoNumber num) {
        return lottoNumbers.contains(num);
    }

    private void validateSize(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개만 가능합니다.");
        }
    }

    private void validateDuplicate(List<Integer> lottoNumbers) {
        Set<Integer> nonDuplicateNumbers = new HashSet<>(lottoNumbers);
        if (nonDuplicateNumbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException("로또 번호들은 중복될 수 없습니다.");
        }
    }
}
