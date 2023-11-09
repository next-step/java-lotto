package lotto.strategy;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomNumberStrategy implements NumberStrategy {

    private static final int MAX_NUMBER = 45;
    private static final List<LottoNumber> LOTTO_NUMBER;

    static {
        LOTTO_NUMBER = new ArrayList<>();
        for (int i = 1; i <= MAX_NUMBER; i++) {
            LOTTO_NUMBER.add(new LottoNumber(i));
        }
    }

    @Override
    public List<Lotto> create(int count) {
        List<LottoNumber> copyLottoNumber = new ArrayList<>(LOTTO_NUMBER);
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(generateLotto(copyLottoNumber));
        }
        return lottos;
    }

    private Lotto generateLotto(List<LottoNumber> lottoNumber) {
        Collections.shuffle(lottoNumber);
        List<LottoNumber> lotto = sliceNumber(lottoNumber);
        return new Lotto(lotto);
    }

    private List<LottoNumber> sliceNumber(List<LottoNumber> lottoNumber) {
        return lottoNumber.subList(0, 6);
    }
}
