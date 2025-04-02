package autoLotto;

import java.util.Set;

public class WinningLotto {
    private Set<Integer> numbers;

    public WinningLotto(Set<Integer> numbers) {
        this.numbers = numbers;
    }

    public Set<Integer> getNumbers() {
        return numbers;
    }

    public void validate() {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("The number of Lotto numbers must be 6.");
        }
    }
}
