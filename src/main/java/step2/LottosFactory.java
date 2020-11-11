package step2;

import java.util.ArrayList;
import java.util.Arrays;
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
            final Lotto lotto = Lotto.of(() -> Arrays.asList(1, 2, 3, 4, 5, 6));
            lottos.add(lotto);
        }
        return Lottos.of(lottos);
    }
}
