package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    private static final int LOTTO_SIZE = 6;
    private List<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {

        if (isDuplicate(numbers)) {
            throw new IllegalArgumentException();
        }

        for (Integer number:numbers){
            this.numbers.add(new LottoNumber(number));
        }

    }

    private boolean isDuplicate(List<Integer> numbers) {
        Set<Integer> checkNumbers = new HashSet<>(numbers);
        return checkNumbers.size() != LOTTO_SIZE;
    }

    public List<Integer> getNumbers(){
        return numbers.stream()
                .map(number -> number.getNumber())
                .collect(Collectors.toList());
    }

}
