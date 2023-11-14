package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    private LottoGenerator() {
    }

    public static Lotto generateARandomLotto() {
        return Lotto.of(pick6Randomly());
    }

    public static List<Lotto> generateRandomLotto(int count) {
        List<Lotto> generatedLottoList = new ArrayList<>(count);

        for (int i = 0; i < count; i++) {
            generatedLottoList.add(generateARandomLotto());
        }

        return generatedLottoList;
    }

    private static List<Integer> pick6Randomly() {
        List<Integer> allLottoNumberList = new ArrayList<>(45);
        for (int i = 1; i <= 45; i++) {
            allLottoNumberList.add(i);
        }

        Collections.shuffle(allLottoNumberList);

        return allLottoNumberList.subList(0, 6);
    }
}
