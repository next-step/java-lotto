package lotto.domain;

import lotto.domain.value.LottoNumber;

import java.util.*;

public class Lotto {

    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;

    private static Random random = new Random();

    private static final String FORM_ERROR_MSG = "로또는 6자리 형식입니다.!!!";

    private List<LottoNumber> numbers;

    public Lotto() {

        this.numbers = createRandomNumbers();
    }

    private Lotto(List<LottoNumber> numbers) {

        if(numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(FORM_ERROR_MSG);
        }

        this.numbers = numbers;
    }

    public static Lotto from(List<LottoNumber> number) {
        return new Lotto(number);
    }

    public static Lotto winningFrom(List<Integer> number) {

        List<LottoNumber> numbers = new ArrayList<>();
        for(int i = 0; i < number.size(); i++) {
            numbers.add(LottoNumber.from(number.get(i)));
        }

        return new Lotto(numbers);
    }

    public List<LottoNumber> getNumbers() {
        return numbers;
    }

    private List<LottoNumber> createRandomNumbers() {

        List<LottoNumber> autoNumbers = new ArrayList<>();

        while (autoNumbers.size() != LOTTO_SIZE) {
            int raffleNumber = random.nextInt(LOTTO_MAX_NUMBER -1) + 1;
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

    public int calculatePrizeMoney(Lotto winningNumbers) {
        return Rank.valueOf(countOfMatch(winningNumbers)).getPrizeMoney();
    }

    private int countOfMatch(Lotto winningNumbers) {
        return (int) numbers.stream()
                .filter(winningNumbers.getNumbers()::contains)
                .count();
    }

    public boolean countOfMatch(Lotto winningNumbers, int count) {
        return (int) numbers.stream()
                .filter(winningNumbers.getNumbers()::contains)
                .count() == count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lotto that = (Lotto) o;
        return Objects.equals(numbers, that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

}
