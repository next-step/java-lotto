package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningLotto {

    private static final int BONUS_IDX = 6;
    private static final int WINNING_LOTTO_SIZE = 7;
    private static final String WINNING_LOTTO_SIZE_EXCEPTION_MESSAGE = "[ERROR] 우승 로또 숫자는 보너스 볼 포함 총 7개 입니다";
    private static final String WINNING_LOTTO_DUPLICATE_EXCEPTION_MESSAGE = "[ERROR] 우승 로또 숫자는 중복 될 수 없습니다";

    private final List<LottoNumber> lottoNumbers;

    public WinningLotto(List<LottoNumber> lottoNumbers) {
        validateDuplicate(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
        validateWinningSize();
    }

    public LottoNumber bonusBall() {
        return lottoNumbers.get(BONUS_IDX);
    }

    public int count() {
        return lottoNumbers.size();
    }

    public int howMatch(Lotto lotto) {
        return (int) onlyWinnerNumbers().stream()
            .filter(lotto::hasValue)
            .count();
    }

    public boolean matchBonus(Lotto lotto) {
        return lotto.hasValue(lottoNumbers.get(BONUS_IDX));
    }

    private void validateDuplicate(List<LottoNumber> lottoNumbers) {
        Set<LottoNumber> removeDuplicates = new HashSet<>(lottoNumbers);
        if (removeDuplicates.size() != lottoNumbers.size()) {
            throw new IllegalArgumentException(WINNING_LOTTO_DUPLICATE_EXCEPTION_MESSAGE);
        }
    }

    private void validateWinningSize() {
        if (lottoNumbers.size() != WINNING_LOTTO_SIZE) {
            throw new IllegalArgumentException(WINNING_LOTTO_SIZE_EXCEPTION_MESSAGE);
        }
    }

    private List<LottoNumber> onlyWinnerNumbers() {
        return lottoNumbers.subList(0, 6);
    }
}
