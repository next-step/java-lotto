package lottoAuto.model;

import java.util.List;

public class Lotto {
    private List<Integer> numbers;

    public Lotto(List<Integer> number) {
        this.numbers = number;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
