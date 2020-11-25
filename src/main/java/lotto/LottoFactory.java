package lotto;

import lotto.domain.Lotto;

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
                .mapToObj(i -> new Lotto())
                .collect(Collectors.toList());
    }
}
