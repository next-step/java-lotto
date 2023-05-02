package step2.service;

import step2.domain.entity.Lotto;
import step2.domain.vo.Number;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static step2.domain.vo.Number.LOTTO_END_NUMBER;
import static step2.domain.vo.Number.LOTTO_START_NUMBER;


public class LottoIssuance {

    private static final int LOTTO_INDEX_FROM = 0;
    private static final int LOTTO_INDEX_TO = 6;

    private static List<Number> lottoNumbers;

    static {
        lottoNumbers = new ArrayList<>();

        for (int i = LOTTO_START_NUMBER; i <= LOTTO_END_NUMBER; i++) {
            lottoNumbers.add(new Number(i));
        }
    }

    private LottoIssuance(){
    }

    public static Lotto issue() {
        Collections.shuffle(lottoNumbers);

        final var lotto = lottoNumbers.subList(LOTTO_INDEX_FROM, LOTTO_INDEX_TO);
        lotto.sort(Comparator.comparingInt(Number::getNumber));

        return new Lotto(new ArrayList<>(lotto));
    }
}
