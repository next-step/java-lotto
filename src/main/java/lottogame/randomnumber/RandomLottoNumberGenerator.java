package lottogame.randomnumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lottogame.domain.LottoNumber;
import lottogame.domain.spi.NumberGenerator;

public class RandomLottoNumberGenerator implements NumberGenerator {

    @Override
    public Set<Integer> generateDistinctNumbers(int count) {
        List<Integer> values = createAllLottoNumbers();
        Collections.shuffle(values);
        return createSubSetFrom(values, count);
    }

    private List<Integer> createAllLottoNumbers() {
        List<Integer> lottoNumbers = new ArrayList<>();
        for (int lottoNumber = LottoNumber.MIN_LOTTO_NUMBER; lottoNumber <= LottoNumber.MAX_LOTTO_NUMBER;
            lottoNumber++) {

            lottoNumbers.add(lottoNumber);
        }
        return lottoNumbers;
    }

    private Set<Integer> createSubSetFrom(List<Integer> nonShuffledValues, int count) {
        return nonShuffledValues.stream()
            .limit(count)
            .collect(Collectors.toSet());
    }
}
