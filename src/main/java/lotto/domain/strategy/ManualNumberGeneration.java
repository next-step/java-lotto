package lotto.domain.strategy;

import lotto.domain.LottoNumber;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class ManualNumberGeneration implements NumberGeneration {
    private final List<Integer> testList;

    public ManualNumberGeneration(List<Integer> list) {
        this.testList = list;
    }

    @Override
    public List<LottoNumber> generate() {
        return testList.stream()
                .map(number -> new LottoNumber(number))
                .collect(toList());
    }
}
