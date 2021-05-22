package kr.insup.lotto.utils;

import kr.insup.lotto.config.LottoConfig;

import java.util.*;

public class LottoAutoGenerator implements NumberGeneratingStrategy {

    private List<Integer> allNumbers() {
        List<Integer> allNumbers = new ArrayList<>();
        for (int i = LottoConfig.MIN_NUMBER; i < LottoConfig.MAX_NUMBER; i++) {
            allNumbers.add(i);
        }
        return allNumbers;
    }

    private List<Integer> lottoAutoNumbers() {
        Collections.shuffle(allNumbers());
        List<Integer> lottoAutoNumbers = allNumbers().subList(0, LottoConfig.PICK_NUMBER);
        Collections.sort(lottoAutoNumbers);
        return lottoAutoNumbers;
    }

    @Override
    public List<Integer> generateNumber() {
        return lottoAutoNumbers();
    }
}
