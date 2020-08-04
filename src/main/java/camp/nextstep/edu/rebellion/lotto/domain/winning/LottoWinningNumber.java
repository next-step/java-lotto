package camp.nextstep.edu.rebellion.lotto.domain.winning;

import camp.nextstep.edu.rebellion.lotto.domain.LottoAward;
import camp.nextstep.edu.rebellion.lotto.domain.ticket.LottoNumber;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoWinningNumber {
    private static final String DELIMITER = ",";
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int WIN = 1;
    private static final int LOSE = 0;

    private final List<Integer> winningNumbers;

    public LottoWinningNumber(String numbers) {
        winningNumbers = generateWinningNumbers(numbers);
    }

    public LottoAward getMatchResult(LottoNumber lottoNumber) {
        return LottoAward.of(winningNumbers
                .stream()
                .mapToInt(winningNumber -> lottoNumber.match(winningNumber) ? WIN : LOSE)
                .sum());
    }

    private List<Integer> generateWinningNumbers(String numbers) {
        return Arrays.stream(numbers.split(DELIMITER))
                .map(Integer::parseInt)
                .map(this::checkRange)
                .collect(Collectors.toList());
    }

    private int checkRange(int number) {
        if(LOTTO_MIN_NUMBER > number || LOTTO_MAX_NUMBER < number) {
            throw new IllegalArgumentException("당첨번호가 잘못되었습니다 " + number);
        }
        return number;
    }
}
