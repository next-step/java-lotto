package lottoAuto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class LottoRandom {
    private static final Random RANDOM = new Random();
    private static final int LOTTO_NUMBER = 45;
    private static final int LOTTO_NUMBER_EACH = 6;

    public UserLottos setLotto(int amount) {
        List<Lotto> lotto = new ArrayList<>();

        for (int x = 0; x < amount; x++) {
            Lotto lottoNumbers = getLottoNumber();
            lotto.add(lottoNumbers);
        }
        UserLottos userLottos = new UserLottos(lotto);
        return userLottos;
    }

    private Lotto getLottoNumber() {
        List<Integer> num = new ArrayList<>();

        for (int i = 0; i < LOTTO_NUMBER_EACH; i++) {
            num.add(RANDOM.nextInt(LOTTO_NUMBER) + 1);
        }
        Collections.shuffle(num);
        Collections.sort(num);
        Lotto lotto = new Lotto(num);

        return lotto;
    }
}
