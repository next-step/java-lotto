package step022;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static step022.LottoConfig.*;

public class MakeRandomNumberRule extends MakeNumberRule {
    @Override
    public List<Integer> makeNumbers() {
        Collections.shuffle(integers);
        return integers.stream().limit(LOTTO_NUMBER_MAX_COUNT).collect(Collectors.toList());
    }
}
