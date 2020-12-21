package lotto.domain;

import util.ValidateUtils;

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

    public Lotto(List<Integer> lotto) {
        validateLotto(lotto);
        this.lotto = mapLotto(lotto);
    }

    private List<LottoNumber> mapLotto(List<Integer> lotto) {
        return lotto.stream()
                .map(number -> new LottoNumber(number))
                .collect(toList());
    }

    private void validateLotto(List<Integer> lotto) {
        validateEmpty(lotto);
        validateSize(lotto);
        validateDuplicate(lotto);
    }

    private void validateEmpty(List<Integer> lotto) {
        if (ValidateUtils.isEmpty(lotto)) {
            throw new IllegalArgumentException(VALID_EMPTY_MESSAGE);
        }
    }

    private void validateSize(List<Integer> lotto) {
        if (lotto.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(VALID_SIZE_MESSAGE);
        }
    }

    private void validateDuplicate(List<Integer> lotto) {
        Set<Integer> distinctLotto = new HashSet<>(lotto);
        if (distinctLotto.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(VALID_DUPLICATE_MESSAGE);
        }
    }

    public int match(List<Integer> winLotto) {
        return (int) winLotto.stream()
                .filter(lottoNumber -> containsLottoNumber(lottoNumber))
                .count();
    }

    private boolean containsLottoNumber(int lottoNumber) {
        return this.lotto.contains(new LottoNumber(lottoNumber));
    }

    @Override
    public String toString() {
        return "Lotto{" +
                "lotto=" + lotto +
                '}';
    }
}
