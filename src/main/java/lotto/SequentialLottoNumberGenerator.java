package lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SequentialLottoNumberGenerator implements LottoNumberGenerator {

    // XXX could exceed LottoGame.LOTTO_NUM_END
    private int nextStartNum = LottoGame.LOTTO_NUM_START;

    @Override
    public List<Integer> generate() {
        List<Integer> generated = IntStream.range(nextStartNum, nextStartNum + LottoGame.LOTTO_PICK_NUMBERS)
                .mapToObj(i -> i)
                .collect(Collectors.toList());

        nextStartNum = generated.get(generated.size() - 1) + 1;

        return generated;
    }
}
