package study.lotto.domain;

import study.lotto.domain.exception.LottoWinningNumberConstructorException;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoWinningNumber {
    private static final int WINNING_NUMBER_SIZE = 6;
    private static final String WINNING_NUMBERS_SIZE_ERROR_MESSAGE =
            "6개의 당첨 번호를 입력하세요.";
    private static final String DUPLICATED_WINNING_NUMBERS_ERROR_MESSAGE =
            "당첨 번호의 중복은 허용되지 않습니다.";

    private Set<LottoNumber> winningNumbers;


    public LottoWinningNumber(List<Integer> winningNumbers) {
        if (Objects.isNull(winningNumbers) ||
                winningNumbers.size() != WINNING_NUMBER_SIZE) {
            throw new LottoWinningNumberConstructorException(
                    WINNING_NUMBERS_SIZE_ERROR_MESSAGE);
        }

        setWinningNumbers(winningNumbers);

        if (this.winningNumbers.size() != WINNING_NUMBER_SIZE) {
            throw new LottoWinningNumberConstructorException(
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

    public List<LottoNumber> getMatches(LottoTicket lottoTicket) {
        return lottoTicket.getLottoNumbers().stream()
                .filter(lottoNumber -> winningNumbers.contains(lottoNumber))
                .collect(Collectors.toList());
    }
}
