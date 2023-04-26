package lotto.model.sample;

import lotto.model.Lotto;
import lotto.model.Number;
import lotto.model.Place;

import java.util.Map;

import static lotto.model.Place.*;

public class LottoSample {
    public static final Number BONUS = Number.of(45);
    public static final Lotto CRITERIA = Lotto.of(1, 2, 3, 4, 5, 6);
    public static final Map<Place, Lotto> lottos = Map.of(
            FIRST, Lotto.of(1, 2, 3, 4, 5, 6),
            SECOND, Lotto.of(1, 2, 3, 4, 5, BONUS.value()),
            THIRD, Lotto.of(1, 2, 3, 4, 5, 7),
            FOURTH, Lotto.of(1, 2, 3, 4, 7, 8),
            FIFTH, Lotto.of(1, 2, 3, 7, 8, 9),
            NONE, Lotto.of(7, 8, 9, 10, 11, 12)
    );

    private LottoSample() {
    }

}
