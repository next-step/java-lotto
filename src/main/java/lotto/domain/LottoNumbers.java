package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumbers {

    private List<Integer> numbers;

    public LottoNumbers(int ... numbers) {
        this.numbers = IntStream.of(numbers).boxed().collect(Collectors.toList());
    }

    public LottoNumbers(int minLottoNumber, int maxLottoNumber) {
        List<Integer> shuffledNumbers = IntStream.rangeClosed(minLottoNumber, maxLottoNumber).boxed().collect(Collectors.toList());
        Collections.shuffle(shuffledNumbers);
        this.numbers = shuffledNumbers.subList(0, 6);
        Collections.sort(this.numbers);
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

}
