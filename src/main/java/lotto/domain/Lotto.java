package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;

public class Lotto {
    private static final String VALID_SIZE_MESSAGE = "로또는 6개의 번호여야 한다.";
    private static final String VALID_EMPTY_MESSAGE = "값이 없습니다.";
    private static final String VALID_DUPLICATE_MESSAGE = "로또 번호는 중복이 불가합니다.";
    private static final int LOTTO_SIZE = 6;

    private final List<LottoNumber> lotto;

    public Lotto(List<LottoNumber> lotto) {
        validate(lotto);
        this.lotto = lotto;
    }

    public static Lotto of(List<Integer> lotto) {
        List<LottoNumber> lottoNumbers = lotto.stream()
                .map(number -> new LottoNumber(number))
                .collect(toList());
        return new Lotto(lottoNumbers);
    }

    private void validate(List<LottoNumber> lotto) {
        validateEmpty(lotto);
        validateSize(lotto);
        validateDuplicate(lotto);
    }

    private void validateEmpty(List<LottoNumber> lotto) {
        if (lotto == null || lotto.isEmpty()) {
            throw new IllegalArgumentException(VALID_EMPTY_MESSAGE);
        }
    }

    private void validateSize(List<LottoNumber> lotto) {
        if (lotto.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(VALID_SIZE_MESSAGE);
        }
    }

    private void validateDuplicate(List<LottoNumber> lotto) {
        Set<LottoNumber> distinctLotto = new HashSet<>(lotto);
        if (distinctLotto.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(VALID_DUPLICATE_MESSAGE);
        }
    }

    public int match(List<LottoNumber> winLotto) {
        return (int) winLotto.stream()
                .filter(lottoNumber -> contains(lottoNumber))
                .count();
    }

    private boolean contains(LottoNumber lottoNumber) {
        return this.lotto.contains(lottoNumber);
    }

    public List<LottoNumber> getLotto() {
        return Collections.unmodifiableList(lotto);
    }

}
