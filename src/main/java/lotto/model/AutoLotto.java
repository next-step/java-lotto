package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class AutoLotto {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    List<Integer> lottoNumbers = new ArrayList<>();

    public AutoLotto() {
        for (int i = MIN_LOTTO_NUMBER; i <= MAX_LOTTO_NUMBER; i++) {
            lottoNumbers.add(i);
        }
    }

    public void createNumbers() {

    }

    public List<Lotto> setLotto(int quantity) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            lottos.add(new Lotto());
        }
        return lottos;
    }
}
