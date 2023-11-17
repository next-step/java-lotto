package lotto.domain;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumber {

    private final List<Integer> numbers;

    public LottoNumber(List<Integer> numbers) {
        if (numbers.stream().anyMatch(n -> n < 1 || n > 45)) {
            throw new IllegalArgumentException("로또 번호 범위는 1 ~ 45 입니다.");
        }
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 6개입니다.");
        }

        this.numbers = numbers;
    }

    public LottoNumber() {
        this.numbers = randomNumbers();
    }

    private List<Integer> randomNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 45; i++) {
            numbers.add(i + 1);
        }

        Collections.shuffle(numbers);
        List<Integer> selectedNumbers = numbers.subList(0, 6);
        Collections.sort(selectedNumbers);

        return selectedNumbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
