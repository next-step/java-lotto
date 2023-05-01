package lottery.domain;

import static java.lang.Integer.parseInt;
import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toSet;
import static lottery.domain.constant.LotteryNumberRule.LOTTERY_NUMBERS_SIZE;

import java.util.Set;

public class WinningNumbers {

    private static final String SEPARATOR = ",";

    private static final String BLANK_REGEX = "\\s";

    private static final String INVALID_INDEX = "로또 번호 수는 총 6개로 구성되어야합니다.";

    private final Set<LotteryNumber> winningNumbers;


    public WinningNumbers(String source) {
        this(toWinningNumbers(source));
    }

    public WinningNumbers(Set<LotteryNumber> winningNumbers) {
        if(invalidSize(winningNumbers)) {
            throw new IllegalArgumentException(INVALID_INDEX);
        }
        this.winningNumbers = winningNumbers;
    }

    private boolean invalidSize(Set<LotteryNumber> winningNumbers) {
        return winningNumbers.size() != LOTTERY_NUMBERS_SIZE.getRuleNumber();
    }

    private static Set<LotteryNumber> toWinningNumbers(String source) {
        return stream(separatedNumbers(source))
                .map(number -> new LotteryNumber(parseInt(number)))
                .collect(toSet());
    }

    private static String[] separatedNumbers(String source) {
        return removeBlank(source).split(SEPARATOR);
    }

    private static String removeBlank(String source) {
        return source.replaceAll(BLANK_REGEX, "");
    }

    public int size() {
        return winningNumbers.size();
    }


}
