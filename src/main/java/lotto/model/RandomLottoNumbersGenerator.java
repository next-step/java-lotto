package lotto.model;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RandomLottoNumbersGenerator implements LottoNumbersGenerator {
    private static final Random random = new Random();

    @Override
    public LottoNumbers generate() {
        Stream<Integer> randomIntegerStream = Stream.generate(RandomLottoNumbersGenerator::generateRandomLottoNumber).limit(Lotto.LOTTO_NUMBER_SIZE);

        return new LottoNumbers(randomIntegerStream.collect(Collectors.toList()));
    }

    private static Integer generateRandomLottoNumber() {
        return random.nextInt(LottoNumber.MAX_NUMBER) + 1;
    }
}
