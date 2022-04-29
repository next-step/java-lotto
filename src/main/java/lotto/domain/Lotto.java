package lotto.domain;

import lotto.exception.InvalidLottoLengthException;

import java.util.*;

public class Lotto {
    private static final int VALID_LOTTO_LENGTH = 6;
    private final Set<Integer> lottoNumber;

    Lotto(List<Integer> lottoNumber) {
        validateLotto(lottoNumber);
        this.lottoNumber = new HashSet<>(lottoNumber);
    }

    private void validateLotto(List<Integer> lottoNumber) {
        final Set<Integer> lotto = new HashSet<>(lottoNumber);
        if (VALID_LOTTO_LENGTH != lotto.size()) {
            throw new InvalidLottoLengthException(lotto.size());
        }
    }

    public Lotto(Integer[] lottoNumber) {
        this(Arrays.asList(lottoNumber));
    }

    public List<Integer> getLottoNumbers() {
        List<Integer> copy = new ArrayList<>(this.lottoNumber);
        Collections.sort(copy);
        return Collections.unmodifiableList(copy);
    }

    public LottoWinnerType winLotto(Lotto previousLotto, int bonusNumber) {
        int countOfDuplicate = countDuplicateValue(previousLotto);
        if (LottoWinnerType.matchCountWithBonus(countOfDuplicate)) {
            return LottoWinnerType.valueOf(countOfDuplicate, lottoNumber.contains(bonusNumber));
        }
        return LottoWinnerType.valueOf(countOfDuplicate, false);
    }

    int countDuplicateValue(Lotto lotto) {
        Set<Integer> copyOfLotto = new HashSet<>(this.lottoNumber);
        copyOfLotto.retainAll(lotto.getLottoNumbers());

        return copyOfLotto.size();
    }

    @Override
    public String toString() {
        return lottoNumber.toString();
    }
}
