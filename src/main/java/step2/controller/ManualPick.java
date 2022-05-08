package step2.controller;

import step2.domain.LottoNumber;
import step2.domain.LottoPickStrategy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

public class ManualPick implements LottoPickStrategy {
    private List<LottoNumber> list;

    public ManualPick(String input) {
        String newInput = input.replace(" ", "");
        String[] split = newInput.split(",");
        list = Arrays.stream(split)
                .map(ManualPick::apply)
                .collect(Collectors.toList());
    }

    private static LottoNumber apply(String input) {
        return new LottoNumber(parseInt(input));
    }

    @Override
    public List<LottoNumber> numberPick() {
        return this.list;
    }
}
