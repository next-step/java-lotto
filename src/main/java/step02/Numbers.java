package step02;

import java.util.ArrayList;
import java.util.List;

public class Numbers {
    private List<Integer> numbers = new ArrayList<>();

    public Numbers(MakeNumberRule numberRule) {
        makeNumbers(numberRule);
    }

    public void makeNumbers(MakeNumberRule numberRule) {
        numbers.addAll(numberRule.makeNumbers());
    }
}
