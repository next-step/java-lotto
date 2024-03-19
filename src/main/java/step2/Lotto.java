package step2;

import java.util.*;

public class Lotto {

    private final NumberGenerator numberGenerator;
    private final LottoNumbers numbers;

    public Lotto(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
        this.numbers = generateLottoNumbers();
    }

    public Lotto(List<Integer> numbers, NumberGenerator numberGenerator) {
        this.numbers = new LottoNumbers(numbers);
        this.numberGenerator = numberGenerator;
    }

    private LottoNumbers generateLottoNumbers() {
        List<Integer> tempNumbers = new ArrayList<>();
        while (tempNumbers.size() < 6) {
            addLottoNumber(tempNumbers, createRandomNumber());
        }
        return new LottoNumbers(tempNumbers);
    }

    private int createRandomNumber() {
        return numberGenerator.generate(45);
    }

    private void addLottoNumber(List<Integer> numList, int num) {
        if (!numList.contains(num)) {
            numList.add(num);
        }
    }

    public List<Integer> getLottoNumbers() {
        return numbers.getLottoNumbers();
    }
}
