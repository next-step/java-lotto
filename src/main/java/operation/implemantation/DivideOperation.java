package operation.implemantation;

import operation.Operation;

public class DivideOperation implements Operation {
    @Override
    public int calculate(int first, int second) {
        return first/second;
    }
}
