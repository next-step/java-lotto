package operation.implemantation;

import operation.Operation;

public class MinusOperation implements Operation {
    @Override
    public int calculate(int first, int second) {
        return first - second;
    }
}
