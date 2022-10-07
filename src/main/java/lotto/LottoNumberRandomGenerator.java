package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumberRandomGenerator {

    public List<Integer> generate() {
        List<Integer> numList = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            numList.add(i);
        }
        Collections.shuffle(numList);

        List<Integer> subList = numList.subList(0, 6);

        return subList;
    }
}
