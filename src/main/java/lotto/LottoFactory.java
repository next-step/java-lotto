package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoFactory {

    private static final String SPLIT_REGAX = ",";
    private static final int LOTTO_COUNT = 6;

    public static LottoViewController createViewController() {
        return new LottoViewController(
                new InputView(),
                new ResultView()
        );
    }

    public static List<Lotto> createLotto(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException("구입 금액을 잘못 입력했습니다.");
        }
        return IntStream.range(0, count)
                .mapToObj(i -> new Lotto(0, LottoGenerator.generateLottoNumber()))
                .collect(Collectors.toList());
    }

    public static List<String> getLastWeekWinningNumbers(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("잘못 된 당첨 번호를 입력했습니다.");
        }
        String[] numbers = input.split(SPLIT_REGAX);
        if (numbers.length != LOTTO_COUNT) {
            throw new IllegalArgumentException("잘못 된 당첨 번호를 입력했습니다.");
        }
        return Arrays
                .stream(numbers)
                .collect(Collectors.toList());
    }
}
