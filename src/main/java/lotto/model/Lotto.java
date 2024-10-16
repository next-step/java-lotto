package lotto.model;

import lotto.utility.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private List<Integer>[] lottos;

    public Lotto() {
    }

    private void initailizeLottos(int lottoCount) {
        lottos = new ArrayList[lottoCount];

        for (int count = 0; count < lottos.length; count++) {
            lottos[count] = new ArrayList<>();
        }
    }

    public List<Integer>[] purchaseLotto(int lottoCount) {
        initailizeLottos(lottoCount);

        for (int count = 0; count < lottoCount; count++) {
            generateLottoNumber(lottos[count]);
            shuffleLottoNumber(lottos[count]);
        }

        return lottos;
    }

    private void generateLottoNumber(List<Integer> lotto) {
        for (int i = 1; i <= 6; i++) {
            lotto.add(RandomNumberGenerator.generateRandomNumber());
        }
    }

    private void shuffleLottoNumber(List<Integer> lotto) {
        Collections.shuffle(lotto);
    }
}
