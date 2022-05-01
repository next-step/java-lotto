package lotto.domain;

import lotto.exception.InvalidLottoLengthException;

import java.util.*;

public class Lotto {
    private static final int VALID_LOTTO_LENGTH = 6;
    private final Set<LottoNumber> lotto;

    Lotto(List<Integer> lottoNumbers) {
        validateLengthOfLotto(lottoNumbers);
        this.lotto = new HashSet<>(castIntegersToLottoNumbers(lottoNumbers));
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
            lotto.add(new LottoNumber(number));
        }
        return lotto;
    }

    public Lotto(Integer[] lottoNumbers) {
        this(Arrays.asList(lottoNumbers));
    }

    public List<LottoNumber> getLottoNumbers() {
        List<LottoNumber> copy = new ArrayList<>(this.lotto);
        Collections.sort(copy);
        return Collections.unmodifiableList(copy);
    }

    public LottoWinnerType winLotto(Lotto previousLotto, int bonusNumber) {
        int countOfDuplicate = countDuplicateValue(previousLotto);
        if (LottoWinnerType.matchCountWithBonus(countOfDuplicate)) {
            return LottoWinnerType.valueOf(countOfDuplicate, lotto.contains(new LottoNumber(bonusNumber)));
        }
        return LottoWinnerType.valueOf(countOfDuplicate, false);
    }

    int countDuplicateValue(Lotto lotto) {
        Set<LottoNumber> copyOfLotto = new HashSet<>(this.lotto);
        copyOfLotto.retainAll(lotto.getLottoNumbers());

        return copyOfLotto.size();
    }

    @Override
    public String toString() {
        return lotto.toString();
    }
}
