package lotto.domain;

import lotto.exception.InvalidLottoLengthException;

import java.util.*;

public class Lotto {
    private static final int VALID_LOTTO_LENGTH = 6;
    private final Set<LottoNumber> lotto;

    public Lotto(Integer[] lottoNumbers) {
        final List<Integer> lotto = Arrays.asList(lottoNumbers);
        validateLengthOfLotto(lotto);
        this.lotto = new HashSet<>(castIntegersToLottoNumbers(lotto));
    }

    private void validateLengthOfLotto(List<Integer> lottoNumbers) {
        final Set<Integer> noDuplicateLottoNumbers = new HashSet<>(lottoNumbers);
        if (VALID_LOTTO_LENGTH != noDuplicateLottoNumbers.size()) {
            throw new InvalidLottoLengthException(noDuplicateLottoNumbers.size());
        }
    }

    private List<LottoNumber> castIntegersToLottoNumbers(List<Integer> lottoNumbers) {
        final List<LottoNumber> lotto = new ArrayList<>();
        for (Integer number : lottoNumbers) {
            lotto.add(LottoNumber.valueOf(number));
        }
        return lotto;
    }

    Lotto(List<LottoNumber> lotto) {
        this.lotto = new HashSet<>(lotto);
    }

    public List<LottoNumber> getLottoNumbers() {
        List<LottoNumber> copy = new ArrayList<>(this.lotto);
        Collections.sort(copy);
        return Collections.unmodifiableList(copy);
    }

    public LottoWinnerType winLotto(LottoWinningCondition winningCondition) {
        return winningCondition.winLotto(this);
    }

    int countDuplicateValue(Lotto lotto) {
        Set<LottoNumber> copyOfLotto = new HashSet<>(this.lotto);
        copyOfLotto.retainAll(lotto.getLottoNumbers());

        return copyOfLotto.size();
    }

    boolean contains(LottoNumber bonusNumber) {
        return this.lotto.contains(bonusNumber);
    }

    @Override
    public String toString() {
        return lotto.toString();
    }
}
