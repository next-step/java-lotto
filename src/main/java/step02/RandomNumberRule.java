package step02;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static step02.LottoConfig.*;

public class RandomNumberRule extends NumberRule {
    @Override
    public List<Integer> makeNumbers() {
        Collections.shuffle(INTEGERS);
        return INTEGERS.stream()
                .limit(LOTTO_NUMBER_MAX_COUNT)
                .collect(Collectors.toList());
    }
}
