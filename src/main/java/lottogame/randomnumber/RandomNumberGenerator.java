package lottogame.randomnumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lottogame.domain.LottoNumber;
import lottogame.domain.spi.NumberGenerator;

public class RandomNumberGenerator implements NumberGenerator {

    @Override
    public Set<Integer> generate(int count) {
        List<Integer> nonShuffledValues = new ArrayList<>();
        for (int lottoNumber = LottoNumber.MIN_LOTTO_NUMBER; lottoNumber <= LottoNumber.MAX_LOTTO_NUMBER;
            lottoNumber++) {

            nonShuffledValues.add(lottoNumber);
        }
        Collections.shuffle(nonShuffledValues);
        return nonShuffledValues.stream()
            .limit(count)
            .collect(Collectors.toSet());
    }
}
