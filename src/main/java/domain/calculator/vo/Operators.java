package domain.calculator.vo;

import java.util.ArrayList;
import java.util.List;

public class Operators {
    private final List<Operator> operatorList = new ArrayList<>();

    public void add(Operator operator) {
        operatorList.add(operator);
    }

    public List<Operator> getOperatorList() {
        return operatorList;
    }

    public int size() {
        return operatorList.size();
    }
}
