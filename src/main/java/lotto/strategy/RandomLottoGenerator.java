package lotto.strategy;

import lotto.domain.LottoNumber;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLottoGenerator implements LottoGenerator {

    private static final Random random = new Random();
    private static final int MAX_NUMBER = 45;
    private static final int LOTTO_NUMBER_SIZE = 6;

    @Override
    public List<LottoNumber> lotto() {
        return IntStream.generate(() -> random.nextInt(MAX_NUMBER) + 1)
                .distinct()
                .limit(LOTTO_NUMBER_SIZE)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
    }
}
