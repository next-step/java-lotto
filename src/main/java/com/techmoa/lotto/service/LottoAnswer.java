package com.techmoa.lotto.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoAnswer {

    public static List<Integer> lottoAnswerNumber = null;
    public static final String ENTER_SPLILT_REGEX = ", ";
    public static String enterAnswerString ;

    public LottoAnswer(String enterAnswerString) {
        this.enterAnswerString = enterAnswerString;
    }

    public LottoAnswer(List<Integer> lottoAnswerNumber) {
        this.lottoAnswerNumber = lottoAnswerNumber;
    }

    public static LottoAnswer getParseEnterString(String enterAnswerString){
        String[] parseString= enterAnswerString.split(ENTER_SPLILT_REGEX);
        return new LottoAnswer(Arrays.stream(parseString)
                .map(Integer::parseInt)
                .collect(Collectors.toList()));
    }

    public List<Integer> getLottoAnswerNumber() {
        return lottoAnswerNumber;
    }




}
