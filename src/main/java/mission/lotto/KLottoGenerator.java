package mission.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class KLottoGenerator implements LottoGenerator {

    private static final String name = "K-mission.lotto.Lotto";
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int LOTTO_NUMBER_MINIMUM_RANGE = 1;
    private static final int LOTTO_NUMBER_MAXIMUM_RANGE = 45;
    public static final int LOTTO_PRICE = 1000;

    @Override
    public List<Integer> generate() {
        List<Integer> numbers = new ArrayList<>();
        for (int number = LOTTO_NUMBER_MINIMUM_RANGE; number <= LOTTO_NUMBER_MAXIMUM_RANGE; number++) {
            numbers.add(number);
        }

        Collections.shuffle(numbers);
        List<Integer> lottos = numbers.subList(0, LOTTO_NUMBER_COUNT)
                .stream()
                .sorted()
                .collect(Collectors.toList());
        return lottos;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPrice() {
        return LOTTO_PRICE;
    }
}
