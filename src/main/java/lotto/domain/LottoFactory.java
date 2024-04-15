package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoFactory {
    private static final List<Integer> numbers = IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList());

    public static Lotto createLotto(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    public static List<Lotto> createLottos(int count) {

        List<Lotto> lottos = new ArrayList<>();
        while (count > 0) {
            lottos.add(LottoFactory.createRandomLotto());
            count -= 1;
        }
        return lottos;
    }

    public static WinningLotto createWinningLotto(List<Integer> numbers, int bonusNumber) {
        return new WinningLotto(numbers, bonusNumber);
    }

    static Lotto createRandomLotto() {
        Collections.shuffle(numbers);
        return createLotto(numbers
                .subList(0, 6)
                .stream()
                .collect(Collectors.toUnmodifiableList()));
    }

}
