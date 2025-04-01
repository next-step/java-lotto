package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {

    private static final List<LottoNum> numbers = init();

    private static List<LottoNum> init() {
        List<LottoNum> initNumbers = new ArrayList<>();
        for (int i = LottoNum.MIN_NUM; i <= LottoNum.MAX_NUM; i++) {
            initNumbers.add(new LottoNum(i));
        }
        return initNumbers;
    }

    public static List<LottoNum> generate() {
        Collections.shuffle(numbers);
        List<LottoNum> generatedNumbers = new ArrayList<>(numbers.subList(0, 6));
        Collections.sort(generatedNumbers);
        return generatedNumbers;
    }
}
