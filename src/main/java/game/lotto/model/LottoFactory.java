package game.lotto.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoFactory {

    public static List<Lotto> createLottos(final Amount amount) {
        return IntStream.range(0, amount.getValue())
                        .mapToObj(i -> new Lotto())
                        .collect(Collectors.toList());
    }


    public static Lotto createLotto() {

        return new Lotto();
    }

}
