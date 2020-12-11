package lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLottoNumberGenerator implements LottoNumberGenerator {

    @Override
    public List<LottoNumber> generate() {
        List<LottoNumber> numbers = IntStream.range(LottoNumber.LOTTO_NUM_START, LottoNumber.LOTTO_NUM_END + 1)
                .mapToObj(i -> new LottoNumber(i)).collect(Collectors.toList());
        Collections.shuffle(numbers);

        return numbers.subList(0, LottoGame.LOTTO_PICK_NUMBERS);
    }

}
