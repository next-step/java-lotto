package lottoAuto.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class LottoRandom {
    private static final int LOTTO_NUMBER = 45;
    private static final int LOTTO_NUMBER_EACH = 6;

    public List<List> setLotto(int amount) {

        List<List> result = new ArrayList<>();

        for (int x = 0; x < amount; x++) {
            List<Integer> num = getLottoNumber();
            result.add(num);
        }

        return result;
    }

    private List<Integer> getLottoNumber() {
        Random random = new Random();
        List<Integer> num = new ArrayList<>();

        for (int i = 0; i < LOTTO_NUMBER_EACH; i++) {
            num.add(random.nextInt(LOTTO_NUMBER) + 1);
        }
        Collections.shuffle(num);
        Collections.sort(num);
        return num;
    }
}
