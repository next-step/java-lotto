package com.ssabae.nextstep.lotto.application;

import java.util.Map;

/**
 * @author : leesangbae
 * @project : java-lotto
 * @since : 2020-12-19
 */
public class LottoResultDto {

    private final Map<Integer, Integer> matchCountMap;
    private final int countOfTicket;

    public LottoResultDto(Map<Integer, Integer> matchCountMap, int countOfTicket) {
        this.matchCountMap = matchCountMap;
        this.countOfTicket = countOfTicket;
    }

    public Map<Integer, Integer> getMatchCountMap() {
        return matchCountMap;
    }

    public int getCountOfTicket() {
        return countOfTicket;
    }
}
