package lotto.domain;

import lotto.domain.value.LottoNumber;

import java.util.*;

public class Lotto {

    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;

    private List<LottoNumber> numbers;

    public Lotto() {

        this.numbers = createRandomNumbers();
    }

    private Lotto(List<LottoNumber> numbers) {

        if(numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또는 6자리 형식입니다.!!!");
        }

        this.numbers = numbers;
    }

    public static Lotto from(List<LottoNumber> number) {
        return new Lotto(number);
    }

    public List<LottoNumber> getNumbers() {
        return numbers;
    }

    private List<LottoNumber> createRandomNumbers() {

        List<LottoNumber> autoNumbers = new ArrayList<>();

        while (autoNumbers.size() != LOTTO_SIZE) {
            int raffleNumber = new Random().nextInt(LOTTO_MAX_NUMBER -1) + 1;
            LottoNumber randomNumber = LottoNumber.from(raffleNumber);
            checkDuplicationNumber(autoNumbers, randomNumber);

        }

        Collections.sort(autoNumbers);

        return autoNumbers;
    }

    private void checkDuplicationNumber(List<LottoNumber> autoNumbers, LottoNumber randomNumber) {
        if(!autoNumbers.contains(randomNumber)) {
            autoNumbers.add(randomNumber);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto that = (Lotto) o;
        return Objects.equals(numbers, that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

}
