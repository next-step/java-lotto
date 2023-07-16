package lottogame.randomnumber;

import lottogame.domain.LottoNumber;
import lottogame.domain.spi.NumberGenerator;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLottoNumberGenerator implements NumberGenerator {

    @Override
    public Set<Integer> generateDistinctNumbers(int count) {
        List<Integer> values = createAllLottoNumbers();
        Collections.shuffle(values);
        return createSubSetFrom(values, count);
    }

    private List<Integer> createAllLottoNumbers() {
        return IntStream.rangeClosed(LottoNumber.MIN_LOTTO_NUMBER, LottoNumber.MAX_LOTTO_NUMBER)
                .boxed()
                .collect(Collectors.toList());
    }

    private Set<Integer> createSubSetFrom(List<Integer> nonShuffledValues, int count) {
        return nonShuffledValues.stream()
            .limit(count)
            .collect(Collectors.toSet());
    }
}
