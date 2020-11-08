package step2.streategy;

import step2.strategy.NumberMakeStrategy;

import java.util.List;

public class TestNumberMakeStrategy implements NumberMakeStrategy {
    private List<Integer> markingNumbers;

    @Override
    public List<Integer> create() {
        return markingNumbers;
    }

    public void setupTestValue(List<Integer> input){
        markingNumbers = input;
    }
}
