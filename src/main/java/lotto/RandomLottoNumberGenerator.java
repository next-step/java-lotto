package lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLottoNumberGenerator implements LottoNumberGenerator {

    @Override
    public List<Integer> generate() {
        List<Integer> numbers = IntStream.range(LottoGame.LOTTO_NUM_START, LottoGame.LOTTO_NUM_END + 1)
                .mapToObj(i -> i).collect(Collectors.toList());
        Collections.shuffle(numbers);

        return numbers.subList(0, LottoGame.LOTTO_PICK_NUMBERS);
    }

}
