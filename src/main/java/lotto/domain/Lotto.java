package lotto.domain;

import java.util.*;

public class Lotto {

    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;

    private static List<Integer> numbers = new ArrayList<>();

    public Lotto() {
        createRandomNumbers();
    }

    private Lotto(List<Integer> number) {

        checkNumber(number);

        this.numbers = number;
    }

    public static Lotto from(List<Integer> number) {
        return new Lotto(number);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void createRandomNumbers() {

        while (numbers.size() != LOTTO_SIZE) {
            Integer randomNumber = (new Random().nextInt(LOTTO_MAX_NUMBER -1) + 1);
            checkDuplicationNumber(numbers, randomNumber);
        }

    }

    private void checkDuplicationNumber(List<Integer> number, Integer randomNumber) {
        if(!number.contains(randomNumber)) {
            number.add(randomNumber);
        }
    }

    private void checkNumber(List<Integer> numbers) {
        if(numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또는 6자리 형식입니다.!!!");
        }

        numbers.forEach(number -> {
            if(number < 1 || number > 45) {
                throw new IllegalArgumentException("로또 숫자는 1~45의 숫자만 입력 가능합니다!!!!");
            }
        });
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
