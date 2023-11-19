package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private static final int LOTTO_NUMBER_COUNT = 6;

    private final List<Integer> numbers = new ArrayList<>();

    Lotto(){
        List<Integer> generatedNumbers = LottoUtil.generateLottoNumber();

        for (int i = 0; i < LOTTO_NUMBER_COUNT; i++){
            numbers.add(generatedNumbers.get(i));
        }

        Collections.sort(numbers);
    }

    List<Integer> numbers(){
        return this.numbers;
    }

    @Override
    public String toString() {
        return "Lotto{" +
                "numbers=" + numbers +
                '}';
    }
}
