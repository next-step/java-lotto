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
    public Lotto generateLottos() {
        return sortLotto(shuffleLotto());
    }

    List<Integer> shuffleLotto() {
        Collections.shuffle(lottoGenerator);
        return new ArrayList<>(lottoGenerator.subList(FROM_INDEX, LOTTO_SIZE));
    }

    Lotto sortLotto(List<Integer> shuffledLotto) {
        Collections.sort(shuffledLotto);
        return new Lotto(shuffledLotto);
    }

}
