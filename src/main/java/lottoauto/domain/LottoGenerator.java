package lottoauto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    public static final int LOTTO_LENGTH = 6;
    private static final List<Integer> NUMBER_CANDIDATES = new ArrayList<>(){};

    private static void generateLottoRange() {
        if(NUMBER_CANDIDATES.size() == MAX_NUMBER){
            return;
        }
        for (int i = MIN_NUMBER ; i < MAX_NUMBER; i++) {
            NUMBER_CANDIDATES.add(i);
        }
    }

    static {
        generateLottoRange();
    }

    public static Lotto makeLotto() {
        Collections.shuffle(NUMBER_CANDIDATES);
        List<Integer> newLotto = new ArrayList<>();
        for (int i = 0; i < LOTTO_LENGTH; i++) {
            newLotto.add(NUMBER_CANDIDATES.get(i));
        }
        Collections.sort(newLotto);
        return new Lotto(newLotto, NUMBER_CANDIDATES.get(LOTTO_LENGTH));
    }
}
