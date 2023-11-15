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
        List<Lotto> generatedLottos = new ArrayList<>(count);

        for (int i = 0; i < count; i++) {
            generatedLottos.add(generateARandomLotto());
        }

        return generatedLottos;
    }

    private static List<Integer> pick6Randomly() {
        List<Integer> allLottoNumbers = new ArrayList<>(45);
        for (int i = 1; i <= 45; i++) {
            allLottoNumbers.add(i);
        }

        Collections.shuffle(allLottoNumbers);

        return allLottoNumbers.subList(0, 6);
    }
}
