package lotto.domain;

import java.util.Arrays;
import java.util.stream.Stream;

public class WinningLotto extends Lotto {
    public WinningLotto(String winningNumbers) {
        super(parseWinningNumbers(winningNumbers));
    }

    private static Integer[] parseWinningNumbers(String winningNumbers) {
        try {
            return Arrays.stream(Arrays.stream(winningNumbers.replaceAll("\\s","").split(",")).mapToInt(Integer::parseInt).toArray())
                    .boxed().toArray(Integer[]::new);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("당첨 번호는 숫자만 입력할 수 있습니다.");
        }
    }

    public Integer compareLotto(Lotto comparedLotto) {
        return Stream.of(this.getLotto())
                .filter(Arrays.asList(comparedLotto.getLotto())::contains)
                .toArray(Integer[]::new).length;
    }
}
