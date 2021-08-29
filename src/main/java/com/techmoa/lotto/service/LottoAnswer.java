package com.techmoa.lotto.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoAnswer {

    public static List<Integer> lottoAnswerNumber = null;
    public static final String ENTER_SPLIT_REGEX = ", ";

    public int purchaseAmount = 0;

    public LottoAnswer(List<Integer> lottoAnswerNumber, int purchaseAmount) {
        this.lottoAnswerNumber = lottoAnswerNumber;
        this.purchaseAmount = purchaseAmount;
    }

    public static LottoAnswer of(String enterAnswerString , int purchaseAmount){
        String[] parseString= enterAnswerString.split(ENTER_SPLIT_REGEX);
        return new LottoAnswer(Arrays.stream(parseString)
                .map(Integer::parseInt)
                .collect(Collectors.toList()), purchaseAmount);
    }

    public List<Integer> getLottoAnswerNumber() {
        return lottoAnswerNumber;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }




}
