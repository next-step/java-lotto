package lotto.model;

public class LottoNumbers {
    private LottoNumber[] numbers = new LottoNumber[Lotto.LIMIT];

    public LottoNumbers() {
        for(int i = 0; i < Lotto.LIMIT; i++) {
            numbers[i] = new LottoNumber();
        }
    }

    public LottoNumbers(LottoNumber[] numbers) {
        this.numbers = numbers;
    }

    public LottoNumber[] getNumbers() {
        return numbers;
    }

    public int getLength() {
        return numbers.length;
    }
}
