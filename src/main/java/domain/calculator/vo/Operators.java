package domain.calculator.vo;

import java.util.ArrayList;
import java.util.List;

public class Operators {
    private final List<OperatorEnum> operatorList = new ArrayList<>();

    public void add(OperatorEnum operator) {
        operatorList.add(operator);
    }

    public List<OperatorEnum> getOperatorList() {
        return operatorList;
    }

    public int size() {
        return operatorList.size();
    }
}
