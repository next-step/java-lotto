package domain.calculator.vo;

import java.util.ArrayList;
import java.util.List;

public class Numbers {
    private final List<Number> numberList = new ArrayList<>();

    public List<Number> getNumbers() {
        return numberList;
    }

    public void add(Number number) {
        numberList.add(number);
    }
}
