package Lotto.model;

import Lotto.model.NumberExtractor.NumberExtractor;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private static final int SIZE = 6;
    private final NumberExtractor extractor;
    private List<LottoNumber> numbers;

    public Lotto(NumberExtractor extractor) {
        this.extractor = extractor;
    }

    public void draw() {
        List<Integer> tempNumberList = this.extractor.extract(SIZE);
        numbers = toLottoNumbers(tempNumberList);

        Collections.sort(numbers);
    }

    static List<LottoNumber> toLottoNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public int checkMatched(List<Integer> winNumbers) {
        int matchedNum = 0;
        List<LottoNumber> winningLottoNumbers = toLottoNumbers(winNumbers);
        for (LottoNumber num : winningLottoNumbers) {
            if (this.numbers.contains(num)) {
                matchedNum++;
            }
        }

        return matchedNum;
    }

    List<LottoNumber> numbers() {
        return Collections.unmodifiableList(numbers);
    }

    public boolean contains(int value) {
        return numbers.stream()
                .anyMatch(num -> num.value() == value);
    }
}
