package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Calculator {
    private final List<String> formulaList;
    private int result;

    public Calculator(List<String> formulaList) {
        this.formulaList = new ArrayList<>(formulaList);
        this.result = 0;
    }

    public void calculateFormula() {
        List<Integer> numberList = makeNumberList();
        List<String> operatorList = makeOperatorList();

    }

    public List<Integer> makeNumberList() {
        return IntStream.range(0, this.formulaList.size())
                .filter(index -> index % 2 == 0)
                .mapToObj(index -> Integer.parseInt(this.formulaList.get(index)))
                .collect(Collectors.toList());
    }

    public List<String> makeOperatorList() {
        return IntStream.range(0, this.formulaList.size())
                .filter(index -> index % 2 == 1)
                .mapToObj(this.formulaList::get)
                .collect(Collectors.toList());
    }

    public int showResult() {
        return result;
    }
}
