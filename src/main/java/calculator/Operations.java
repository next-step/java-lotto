package calculator;

import java.util.List;

public class Operations {

    private int index;
    private List<String> operations;

    public Operations(List<String> operations) {
        this.index = 0;
        this.operations = operations;
    }

    public boolean isAddition() {
        if ("+".equals(operations.get(index))) {
            return true;
        }
        return false;
    }

    public boolean isSubtraction() {
        if ("-".equals(operations.get(index))) {
            return true;
        }
        return false;
    }

    public boolean isMultiplication() {
        if ("*".equals(operations.get(index))) {
            return true;
        }
        return false;
    }

    public boolean isDivision() {
        if ("/".equals(operations.get(index))) {
            return true;
        }
        return false;
    }
}
