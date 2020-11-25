package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoFactory {

    public static LottoViewController createViewController() {
        return new LottoViewController(
                new InputView(),
                new ResultView()
        );
    }

    public static List<Lotto> createLotto(int count) {
        return IntStream.range(0, count)
                .mapToObj(i -> new Lotto(0, LottoGenerator.generateLottoNumber()))
                .collect(Collectors.toList());
    }

    public static List<String> getLastWeekWinningNumbers(String input) {
        return Arrays
                .stream(input.trim().split(","))
                .collect(Collectors.toList());
    }
}
