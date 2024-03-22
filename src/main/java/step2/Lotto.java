package step2;

import java.util.*;

public class Lotto {

    private final NumberGenerator numberGenerator;
    private final LottoNumbers numbers;

    public Lotto(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
        this.numbers = generateLottoNumbers();
    }

    public Lotto(LottoNumbers numbers, NumberGenerator numberGenerator) {
        this.numbers = numbers;
        this.numberGenerator = numberGenerator;
    }

    private LottoNumbers generateLottoNumbers() {
        List<LottoNumber> tempNumbers = new ArrayList<>();
        while (tempNumbers.size() < 6) {
            addLottoNumber(tempNumbers, createRandomNumber());
        }
        return new LottoNumbers(tempNumbers);
    }

    private int createRandomNumber() {
        return numberGenerator.generate(45);
    }

    private void addLottoNumber(List<LottoNumber> numList, int num) {
        LottoNumber temp = new LottoNumber(num);
        if (!numList.contains(temp)) {
            numList.add(temp);
        }
    }

    public List<LottoNumber> getLottoNumbers() {
        return numbers.getLottoNumbers();
    }

    public int matchedNumbersCount(LottoNumbers winNumbers) {
        return numbers.matchedNumbersCount(winNumbers);
    }

    public boolean hasBonus(LottoNumber bonusNumber) {
        return numbers.matchedNumber(bonusNumber.getNumber());
    }

    public String getLottoNumberString() {
        return numbers.getLottoNumbersAsString();
    }
}
