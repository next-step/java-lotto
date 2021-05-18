package lottoAuto.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class LottoRandom {
    private static final int LOTTO_NUMBER = 45;
    private static final int LOTTO_NUMBER_EACH = 6;

    public List<Lotto> setLotto(int amount) {

        List<Lotto> lottos = new ArrayList<>();

        for (int x = 0; x < amount; x++) {
            Lotto lottoNumber = getLottoNumber();
            lottos.add(lottoNumber);
        }

        return lottos;
    }

    private Lotto getLottoNumber() {
        Random random = new Random();
        Lotto lotto = null;
        List<Integer> num = new ArrayList<>();

        for (int i = 0; i < LOTTO_NUMBER_EACH; i++) {
            num.add(random.nextInt(LOTTO_NUMBER) + 1);
        }
        Collections.shuffle(num);
        Collections.sort(num);
        lotto = new Lotto(num);

        return lotto;
    }
}
