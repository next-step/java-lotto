package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumbersPool {
    public static final List<Integer> pool = generatePool();

    static private List<Integer> generatePool() {
        ArrayList<Integer> numberList = new ArrayList<>();
        for (int number = LottoNumbers.MIN_NUMBER; number <= LottoNumbers.MAX_NUMBER; number++) {
            numberList.add(number);
        }
        return Collections.unmodifiableList(numberList);
    }
}
