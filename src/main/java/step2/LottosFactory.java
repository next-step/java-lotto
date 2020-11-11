package step2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottosFactory {
    public static Lottos create(final int count) {
        final List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            final Lotto lotto = Lotto.of(() -> Arrays.asList(1, 2, 3, 4, 5, 6));
            lottos.add(lotto);
        }
        return Lottos.of(lottos);
    }
}
