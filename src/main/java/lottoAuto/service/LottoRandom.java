package lottoAuto.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class LottoRandom {
    public List<List> setLotto(int amount) {
        Random random = new Random();
        List<List> result = new ArrayList<>();

        for (int x = 0; x < amount; x++) {
            List<Integer> num = new ArrayList<>();

            for (int i = 0; i < 6; i++) {
                num.add(random.nextInt(45) + 1);
            }
            Collections.shuffle(num);
            Collections.sort(num);
            result.add(num);
        }

        return result;
    }
}
