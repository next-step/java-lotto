package lotto.domain;

import lombok.Getter;

import java.util.Collections;
import java.util.List;

public class Lotto {
    @Getter
    private List<Integer> numbers;

    Lotto(List<Integer> numbers) {
        if(numbers.size() != 6) {
            throw new RuntimeException("Lotto number must be 6");
        }

        Collections.sort(numbers);

        this.numbers = numbers;
    }

    public int getSameCount(List<Integer> lottoNumbers) {
        int sameCount = 0;

        for (Integer number : numbers) {
            if (lottoNumbers.contains(number)) {
                sameCount++;
            }
        }

        return sameCount;
    }
}
