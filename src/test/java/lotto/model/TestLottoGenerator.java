package lotto.model;

import lotto.LottoGenerator;
import lotto.LottoNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class TestLottoGenerator implements LottoGenerator {

    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int LOTTO_NUMBER_MINIMUM_RANGE = 1;
    private static final int LOTTO_NUMBER_MAXIMUM_RANGE = 6;
    public static final int LOTTO_PRICE = 1000;

    @Override
    public List<LottoNumber> generate() {
        List<LottoNumber> numbers = new ArrayList<>();
        for (int number = LOTTO_NUMBER_MINIMUM_RANGE; number <= LOTTO_NUMBER_MAXIMUM_RANGE; number++) {
            numbers.add(LottoNumber.of(number));
        }

        Collections.shuffle(numbers);
        List<LottoNumber> lottos = numbers.subList(0, LOTTO_NUMBER_COUNT)
                .stream()
                .sorted()
                .collect(Collectors.toList());

        return lottos;
    }


    @Override
    public int getPrice() {
        return LOTTO_PRICE;
    }
}
