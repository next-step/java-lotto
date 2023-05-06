package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoFactory {

    public static final List<Integer> NUMBERS = new ArrayList<>();

    static {
        for (int i = 1; i <= 45; i++) {
            NUMBERS.add(i);
        }
    }

    public static List<Lotto> generateLottoNumbers(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Collections.shuffle(NUMBERS);
            List<Integer> selectedNumbers = new ArrayList<>(NUMBERS.subList(0, 6));
            lottos.add(new Lotto(selectedNumbers));
        }
        return lottos;
    }
}
