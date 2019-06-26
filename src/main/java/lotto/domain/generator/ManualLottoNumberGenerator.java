package lotto.domain.generator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wyparks2@gmail.com on 2019-06-25
 * Blog : http://wyparks2.github.io
 * Github : http://github.com/wyparks2
 */
public class ManualLottoNumberGenerator implements LottoNumbersGenerator {
    private List<Integer> numbers;

    public ManualLottoNumberGenerator(List<Integer> numbers) {
        this.numbers = new ArrayList<>(numbers);
    }

    @Override
    public List<Integer> generate() {
        return new ArrayList<>(this.numbers);
    }
}
