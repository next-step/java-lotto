package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoShuffleGenerator implements LottoGenerator {

    private static LottoShuffleGenerator lottoShuffleGenerator;

    private LottoShuffleGenerator() {

    }

    public static LottoShuffleGenerator getLottoShuffleGenerator() {
        if (lottoShuffleGenerator == null) {
            lottoShuffleGenerator = new LottoShuffleGenerator();
        }
        return lottoShuffleGenerator;
    }

    @Override
    public List<Lotto> generateLottos(int numberOfLotto) {
        List<Lotto> purChasedLotto = new ArrayList<>();
        int lottoCount = numberOfLotto;
        for (int i = 0; i < lottoCount; i++) {
            purChasedLotto.add(sortLotto(shuffleLotto()));
        }
        return purChasedLotto;
    }

    List<LottoNumber> shuffleLotto() {
        Collections.shuffle(lottoGenerator);
        return new ArrayList<>(lottoGenerator.subList(FROM_INDEX, LOTTO_SIZE));
    }

    Lotto sortLotto(List<LottoNumber> shuffledLotto) {
        Collections.sort(shuffledLotto);
        return new Lotto(shuffledLotto);
    }

}
