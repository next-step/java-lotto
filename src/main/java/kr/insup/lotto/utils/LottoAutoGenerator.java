package kr.insup.lotto.utils;

import kr.insup.lotto.config.LottoConfig;

import java.util.*;

public class LottoAutoGenerator implements NumberGenerator {

    private List<Integer> lottoAutoNumbers() {
        List<Integer> allNumbers = NumberGenerator.allNumbers();
        Collections.shuffle(allNumbers);

        return allNumbers.subList(0, LottoConfig.LOTTO_COUNT);
    }

    @Override
    public List<Integer> generateNumber() {
        return lottoAutoNumbers();
    }
}
