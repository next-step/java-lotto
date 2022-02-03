package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class BuyLotto implements Lotto{

    private final List<Integer> numbers;

    public BuyLotto(List<Integer> numbers) {
        this.numbers = new ArrayList<>(numbers);
    }

    @Override
    public List<Integer> getLotto() {
        return numbers;
    }
}
