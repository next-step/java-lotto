package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

    private static final int MAX_LOTTO_LENGTH = 6;
    private static final int FIVE_MATCHING = 5;
    private static final String LOTTO_NUMBER_VALIDATION_MESSAGE = "로또는 6개의 숫자입니다";

    private final List<Integer> lottoNumbers;
    private int matchCount;
    private boolean bonusMatch;

    public Lotto(List<Integer> lottoNumbers) {
        validateLotto(lottoNumbers);
        Collections.sort(lottoNumbers);
        this.lottoNumbers = new ArrayList<>(lottoNumbers);
    }

    public Lotto(List<Integer> lottoNumbers, int matchCount, boolean bonusMatch) {
        this(lottoNumbers);
        this.matchCount = matchCount;
        this.bonusMatch = bonusMatch;
    }

    private void validateLotto(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != MAX_LOTTO_LENGTH) {
            throw new IllegalArgumentException(LOTTO_NUMBER_VALIDATION_MESSAGE);
        }
    }

    public int matchLottoWithWinningNumber(WinningNumber winningNumber) {
        matchCount = 0;
        bonusMatch = false;
        matchCount = winningNumber.findMatchingCount(lottoNumbers);
        if (matchCount == FIVE_MATCHING) {
            bonusMatch = winningNumber.isContainBonusBall(lottoNumbers);
        }
        return matchCount;
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean getBonusMatch() {
        return bonusMatch;
    }
}
