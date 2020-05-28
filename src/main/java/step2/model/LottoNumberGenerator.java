package step2.model;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoNumberGenerator {

    private static final Random random = new Random();
    private static final Set<Integer> generatedLottoNumber = new LinkedHashSet<>();

    private static final int LOTTO_NUMBER_MAX_COUNT = 6;

    public static List<LottoNumber> generate() {
        generatedLottoNumber.clear();

        while (generatedLottoNumber.size() < LOTTO_NUMBER_MAX_COUNT) {
            generatedLottoNumber.add(getRandomNumber());
        }

        return generatedLottoNumber.stream()
                .map(LottoNumber::valueOf)
                .collect(Collectors.toList());
    }

    private static int getRandomNumber() {
        return random.nextInt(45) + 1;
    }
}
