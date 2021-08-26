package com.techmoa.lotto.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoAnswer {

    private static List<Integer> lottoAnswerNumber = null;

    public LottoAnswer(String enterAnswerString) {
        parseEnterAnswerString(enterAnswerString);
    }

    public void parseEnterAnswerString(String enterAnswerString){
        String[] parseString= enterAnswerString.split(", ");
        this.lottoAnswerNumber=  Arrays.stream(parseString)
                                        .map(Integer::parseInt)
                                        .collect(Collectors.toList());
    }

    public List<Integer> getLottoAnswerNumber() {
        return lottoAnswerNumber;
    }




}
