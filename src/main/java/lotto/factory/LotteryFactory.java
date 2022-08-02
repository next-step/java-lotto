package lotto.factory;

import lotto.domain.LotteryNumber;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LotteryFactory {
    private static final String SPILT_COMMA_AND_TRIM = "\\s*,\\s*";
    private static final int COUNT_OF_LOTTO_NUMBERS = 6;

    public static List<LotteryNumber> create(String numbers) {
        String[] winningNumberArray = numbers.split(SPILT_COMMA_AND_TRIM);
        if (winningNumberArray.length != COUNT_OF_LOTTO_NUMBERS) {
            throw new IllegalArgumentException("로또 당첨 번호는 6개의 숫자를 입력해야 합니다.");
        }

        return Arrays.stream(winningNumberArray).mapToInt(Integer::parseInt).sorted()
                .mapToObj(LotteryNumber::of).collect(Collectors.toList());
    }
}
