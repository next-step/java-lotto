package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumbersPool {
    public static final List<LottoNumber> pool = generatePool();

    static private List<LottoNumber> generatePool() {
        ArrayList<LottoNumber> numberList = new ArrayList<>();
        for (int number = LottoNumber.MIN_NUMBER; number <= LottoNumber.MAX_NUMBER; number++) {
            numberList.add(new LottoNumber(number));
        }
        return Collections.unmodifiableList(numberList);
    }
}
