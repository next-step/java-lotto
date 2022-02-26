package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private static final int MAX_LOTTO_LENGTH = 6;
    private static final int FIVE_MATCHING = 5;
    private static final String LOTTO_NUMBER_VALIDATION_MESSAGE = "로또는 6개의 숫자입니다";
    private static final String DUPLICATE_MANUAL_LOTTO_MESSAGE = "중복된 로또 번호입니다";

    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        validateLotto(lottoNumbers);
        checkDuplicateLottoNumber(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validateLotto(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != MAX_LOTTO_LENGTH) {
            throw new IllegalArgumentException(LOTTO_NUMBER_VALIDATION_MESSAGE);
        }
    }

    private void checkDuplicateLottoNumber(List<LottoNumber> manualLottoNumbers) {
        Set<LottoNumber> checkSet = new HashSet<>(manualLottoNumbers);
        if (checkSet.size() < manualLottoNumbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_MANUAL_LOTTO_MESSAGE);
        }
    }


    public MatchInfo matchLottoWithWinningNumber(WinningNumber winningNumber) {
        int matchCount;
        boolean bonusMatch = false;
        matchCount = winningNumber.findMatchingCount(lottoNumbers);
        if (matchCount == FIVE_MATCHING) {
            bonusMatch = winningNumber.isContainBonusBall(lottoNumbers);
        }
        return new MatchInfo(matchCount, bonusMatch);
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

}
