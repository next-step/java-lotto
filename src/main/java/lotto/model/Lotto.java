package lotto.model;

public class Lotto {
    private LottoNumbers numbers;

    public static final int LOTTO_NUMBER_SIZE = 6;

    public Lotto(LottoNumbers numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("로또는 " + LOTTO_NUMBER_SIZE + " 개의 숫자로 이루어져야 합니다!");
        }

        this.numbers = numbers;
    }

    public LottoNumbers getNumbers() {
        return numbers;
    }

    public int countCorrect(Lotto other) {
        int equalCount = 0;
        for (LottoNumber number : other.getNumbers()) {
            equalCount = incrementIfContains(equalCount, number);
        }

        return equalCount;
    }

    private int incrementIfContains(int equalCount, LottoNumber number) {
        if (numbers.contain(number)) {
            return equalCount + 1;
        }
        return equalCount;
    }

    public boolean contain(LottoNumber bonusNumber) {
        return numbers.contain(bonusNumber);
    }
}
