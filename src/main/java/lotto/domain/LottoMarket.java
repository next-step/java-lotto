package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMarket {

    public static List<Integer> createNumbers() {
        List<Integer> allNumber = new ArrayList<>();

        for (int i = 1; i < 46; i++) {
            allNumber.add(i);
        }

        Collections.shuffle(allNumber);

        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            numbers.add(allNumber.get(i));
        }

        return numbers;
    }
}
