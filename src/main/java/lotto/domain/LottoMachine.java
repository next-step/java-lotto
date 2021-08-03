package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class LottoMachine {

    static final int PRICE_OF_LOTTO = 1000;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_GENERATION_COUNT_RANGE_START = 0;
    private static final int LOTTO_GENERATION_COUNT_RANGE_END = 6;

    private int purchaseLottoCount;
    private int purchaseAmount;


    public LottoMachine(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
        purchaseLottoCount = purchaseAmount / PRICE_OF_LOTTO;
    }

    public int getPurchaseLottoCount() {
        return purchaseLottoCount;
    }

    public LottoNumbers generateLottoNumber() {

        List<LottoNumber> lottoNumberList = new ArrayList<>();

        for (int i = MIN_LOTTO_NUMBER; i <= MAX_LOTTO_NUMBER; i++) {
            lottoNumberList.add(LottoNumber.of(i));
        }

        Collections.shuffle(lottoNumberList);

        return LottoNumbers.of(new HashSet<>(lottoNumberList.subList(LOTTO_GENERATION_COUNT_RANGE_START, LOTTO_GENERATION_COUNT_RANGE_END)));

    }


}
