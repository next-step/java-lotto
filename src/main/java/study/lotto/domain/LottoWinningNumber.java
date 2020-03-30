package study.lotto.domain;

import study.lotto.domain.exception.IllegalLottoWinningNumberArgumentException;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class LottoWinningNumber {
    private static final int WINNING_NUMBER_SIZE = 6;
    private static final String WINNING_NUMBERS_SIZE_ERROR_MESSAGE =
            "6개의 당첨 번호를 입력하세요.";
    private static final String DUPLICATED_WINNING_NUMBERS_ERROR_MESSAGE =
            "당첨 번호의 중복은 허용되지 않습니다.";
    private static final String DUPLICATED_BONUS_NUMBER_ERROR_MESSAGE =
            "보너스 번호의 중복은 허용되지 않습니다.";

    private Set<LottoNumber> winningNumbers;
    private LottoNumber bonusNumber;

    public LottoWinningNumber(List<Integer> winningNumbers, int bonusNumber) {
        if (Objects.isNull(winningNumbers) ||
                winningNumbers.size() != WINNING_NUMBER_SIZE) {
            throw new IllegalLottoWinningNumberArgumentException(
                    WINNING_NUMBERS_SIZE_ERROR_MESSAGE);
        }
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalLottoWinningNumberArgumentException(
                    DUPLICATED_BONUS_NUMBER_ERROR_MESSAGE);
        }
        this.bonusNumber = new LottoNumber(bonusNumber);
        setWinningNumbers(winningNumbers);

        if (this.winningNumbers.size() != WINNING_NUMBER_SIZE) {
            throw new IllegalLottoWinningNumberArgumentException(
                    DUPLICATED_WINNING_NUMBERS_ERROR_MESSAGE);
        }
    }

    private void setWinningNumbers(List<Integer> winningNumbers) {
        this.winningNumbers = new HashSet<>();
        for (int number : winningNumbers) {
            this.winningNumbers.add(new LottoNumber(number));
        }
    }

    public int size() {
        return winningNumbers.size();
    }

    public LottoRank rank(LottoTicket lottoTicket) {
        int matchCount = (int) lottoTicket.getLottoNumbers().stream()
                .filter(lottoNumber -> winningNumbers.contains(lottoNumber))
                .count();
        boolean matchBonus = lottoTicket.contains(bonusNumber);

        return LottoRank.valueOf(matchCount, matchBonus);
    }
}
