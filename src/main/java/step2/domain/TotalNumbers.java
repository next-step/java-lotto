package step2.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TotalNumbers {

    private static final List<Integer> totalNumbers = new ArrayList<>();

    static {
        for (int i = 1; i <= 45; i++) {
            totalNumbers.add(i);
        }
    }

    private static final int MAX_SIZE = 6;
    private static final int MIN_SIZE = 0;


    public List<Integer> getRandomLottoNumber() {
        List<Integer> numbers = new ArrayList<>(totalNumbers);

        Collections.shuffle(numbers);
        List<Integer> lottoNumbers = numbers.subList(MIN_SIZE, MAX_SIZE);
        Collections.sort(lottoNumbers);

        return lottoNumbers;
    }
}
