package com.cheolhyeonpark.lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoInformation {

    public static final int GAME_PRICE = 1_000;

    private final List<LottoNumbers> lottoNumbersList = new ArrayList<>();
    private final int amount;

    public LottoInformation(int amount) {
        this.amount = amount;
    }

    public int getGameCount() {
        return amount / GAME_PRICE;
    }

    public void addLottoNumbers(LottoNumbers lottoNumbers) {
        lottoNumbersList.add(lottoNumbers);
    }

    public List<LottoNumbers> getLottoNumbersList() {
        return lottoNumbersList;
    }
}
