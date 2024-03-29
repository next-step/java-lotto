package lotto.domain;

import lotto.constant.Constants;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    public static Lottos createLottos(int count) {
        List<Lotto> lottoList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            lottoList.add(createLotto(shuffleLotto()));
        }

        return new Lottos(lottoList);
    }

    public static Lotto createLotto(List<Integer> shuffledLotto) {
        Collections.sort(shuffledLotto);
        return new Lotto(shuffledLotto);
    }

    public static List<Integer> shuffleLotto() {
        List<Integer> lottoNumbers = new ArrayList<>();

        for (int number = Constants.MIN_LOTTO; number <= Constants.MAX_LOTTO; number++) {
            lottoNumbers.add(number);
        }

        Collections.shuffle(lottoNumbers);

        return lottoNumbers.subList(0, Constants.LOTTO_SIZE);
    }

}
