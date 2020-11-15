package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.List;

import static util.Preconditions.checkArgument;

public class LottosFactory {
    public static final String COUNT_MUST_NOT_BE_NEGATIVE = "count must not be negative";
    
    public static Lottos create(final int count) {
        checkArgument(count >= 0, COUNT_MUST_NOT_BE_NEGATIVE);
        
        if (count == 0) {
            return Lottos.EMPTY;
        }

        final List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            final Lotto lotto = Lotto.of();
            lottos.add(lotto);
        }
        return Lottos.of(lottos);
    }
}
