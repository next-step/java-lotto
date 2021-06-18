package lotto.objects;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final Set<Integer> numbers;

    public Lotto() {
        this.numbers = new HashSet<>();
    }

    public Lotto(Set<Integer> numbers) {
        if (numbers.size() < 6) {
            throw new IllegalArgumentException("로또의 개수가 6보다 작습니다.");
        }
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        List<Integer> transformedNumbers = new ArrayList<>(numbers);
        return transformedNumbers;
    }

    public void addNumber(int number) {
        numbers.add(number);
    }

    public int countSameNumbers(Lotto winningLotto) {
        return (int) numbers.stream()
                .filter(lottoNumber -> winningLotto.contains(lottoNumber))
                .count();
    }

    private boolean contains(Integer lottoNumber) {
        return numbers.contains(lottoNumber);
    }

}
