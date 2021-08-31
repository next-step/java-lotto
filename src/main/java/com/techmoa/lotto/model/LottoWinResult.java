package com.techmoa.lotto.model;

import java.util.HashMap;

public class LottoWinResult {

    private final HashMap<Integer,Integer> resultMap ;
    private final Float profitRate ;

    public LottoWinResult(HashMap<Integer,Integer> resultMap , Float profitRate) {
        this.resultMap = resultMap;
        this.profitRate = profitRate;
    }

    public HashMap<Integer, Integer> getResultMap() {
        return resultMap;
    }

    public Float getProfitRate() {
        return profitRate;
    }
}
