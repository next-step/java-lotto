package step02;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static step02.Config.*;

public class MakeRandomNumberRule implements MakeNumberRule {

    @Override
    public List<Integer> makeNumbers() {
        Collections.shuffle(integers);
        return integers.stream().limit(LOTTO_NUMBER_MAX_COUNT).collect(Collectors.toList());
    }
}
