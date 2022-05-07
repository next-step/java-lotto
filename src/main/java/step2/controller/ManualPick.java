package step2.controller;

import step2.domain.LottoPickStrategy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ManualPick implements LottoPickStrategy {
    private List<Integer> list;

    public ManualPick(String input) {
        String newInput = input.replace(" ", "");
        String[] split = newInput.split(",");
        list = Arrays.stream(split)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    @Override
    public List<Integer> numberPick() {
        return this.list;
    }
}
