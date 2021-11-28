package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int NUMBER_COUNT = 6;

    private int[] numbers;

    public LottoNumber() {
        generateLottoNumber();
    }

    public LottoNumber(int[] numbers) {
        this.numbers = numbers;
    }

    public void generateLottoNumber(){
        List<Integer> lottoRangeNumber = IntStream.range(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER+1)
                .mapToObj(i->i)
                .collect(Collectors.toList());

        Collections.shuffle(lottoRangeNumber);

        Integer[] generateNumbers = lottoRangeNumber.stream()
                .limit(NUMBER_COUNT)
                .toArray(Integer[]::new);

        this.numbers = Arrays.stream(generateNumbers).mapToInt(Integer::intValue).toArray();
    }

    public int[] getLottoNumber(){
        return numbers;
    }

    @Override
    public String toString() {
        return "LottoNumber{" +
                "numbers=" + Arrays.toString(numbers) +
                '}';
    }
}
