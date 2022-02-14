package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningLotto {

    private static final int BONUS_IDX = 6;
    private static final int WINNING_LOTTO_SIZE = 7;
    private static final String WINNING_LOTTO_SIZE_EXCEPTION_MESSAGE = "[ERROR] 우승 로또 숫자는 보너스 볼 포함 총 7개 입니다";
    private static final String WINNING_LOTTO_DUPLICATE_EXCEPTION_MESSAGE = "[ERROR] 우승 로또 숫자는 중복 될 수 없습니다";

    private final List<LottoNumber> lottoNumbers;

    private WinningLotto(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static WinningLotto from(List<LottoNumber> lottoNumbers) {
        validateDuplicate(lottoNumbers);
        validateWinningSize(lottoNumbers);
        return new WinningLotto(lottoNumbers);
    }

    public static WinningLotto of(List<LottoNumber> winningLottoLine, LottoNumber bonusBall) {
        winningLottoLine.add(bonusBall);
        return new WinningLotto(new ArrayList<>(winningLottoLine));
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

    private static void validateDuplicate(List<LottoNumber> lottoNumbers) {
        Set<LottoNumber> removeDuplicates = new HashSet<>(lottoNumbers);
        if (removeDuplicates.size() != lottoNumbers.size()) {
            throw new IllegalArgumentException(WINNING_LOTTO_DUPLICATE_EXCEPTION_MESSAGE);
        }
    }

    private static void validateWinningSize(
        List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != WINNING_LOTTO_SIZE) {
            throw new IllegalArgumentException(WINNING_LOTTO_SIZE_EXCEPTION_MESSAGE);
        }
    }

    private List<LottoNumber> onlyWinnerNumbers() {
        return lottoNumbers.subList(0, 6);
    }
}
