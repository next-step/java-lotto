package model;

import java.util.List;
import java.util.stream.Collectors;

public class Inputs {

    private final List<List<Integer>> numbers;

    public Inputs(final List<List<Integer>> numbers) {
        this.numbers = numbers;
    }

    public List<Lotto> createLottos() {
        return numbers.stream()
                .map(Lotto::new)
                .collect(Collectors.toList());
    }
}
