package step1.domain.num;

import java.util.ArrayList;
import java.util.List;

public class Nums {
    private final List<Num> nums = new ArrayList<>();

    public Nums(Num firstNum, Num secondNum) {
        add(firstNum);
        add(secondNum);
    }

    public Num firstNum() {
        return nums.get(0);
    }

    public Num secondNum() {
        return nums.get(1);
    }

    private void add(Num num) {
        nums.add(num);
    }
}
