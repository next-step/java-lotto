package step2.domain.strategy;

import step2.domain.LottoNumber;
import step2.util.UserInputParser;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

public class ManualPick implements LottoPickStrategy {
    private List<LottoNumber> list;

    public ManualPick(String input) {
        list = Arrays.stream(UserInputParser.impl(input))
                .map(ManualPick::apply)
                .collect(Collectors.toList());
    }

    private static LottoNumber apply(String input) {
        return LottoNumber.create(input);
    }

    @Override
    public List<LottoNumber> numberPick() {
        return this.list;
    }
}
