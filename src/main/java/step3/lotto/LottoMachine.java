package step3.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {

    private static final List<Integer> TOTAL_NUMBERS =
            IntStream.range(1, 46).boxed().collect(Collectors.toList());

    public static Lottos generateLottos(long count) {
        List<Lotto> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Lotto lotto = generateLotto();
            result.add(lotto);
        }
        return new Lottos(result);
    }

    public static Lotto generateLotto() {
        return new Lotto(shuffleNumbers());
    }

    private static LottoNumber shuffleNumbers() {
        List<Integer> numbers = new ArrayList<>();
        Collections.shuffle(TOTAL_NUMBERS);
        for (int i = 0; i < 6; i++) {
            Integer number = TOTAL_NUMBERS.get(i);
            numbers.add(number);
        }

        Collections.sort(numbers);
        return new LottoNumber(numbers);
    }
}
