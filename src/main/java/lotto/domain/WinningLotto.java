package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningLotto extends Lotto {
    public WinningLotto(String winningNumbers) {
        super(parseWinningNumbers(winningNumbers));
    }

    private static List<Integer> parseWinningNumbers(String winningNumbers) {
        try {
            return Arrays.stream(
                    winningNumbers.replaceAll("\\s", "").split(",")
            ).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("당첨 번호는 숫자만 입력할 수 있습니다.");
        }
    }

    public Integer compareLotto(Lotto comparedLotto) {
        return (int) this.getLotto().stream().filter(comparedLotto.getLotto()::contains).count();
    }
}
