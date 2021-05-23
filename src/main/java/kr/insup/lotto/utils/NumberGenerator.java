package kr.insup.lotto.utils;

import kr.insup.lotto.config.LottoConfig;

import java.util.ArrayList;
import java.util.List;

public interface NumberGenerator {

    static List<Integer> allNumbers() {
        List<Integer> allNumbers = new ArrayList<>();

        for (int i = LottoConfig.MIN_NUMBER; i < LottoConfig.MAX_NUMBER; i++) {
            allNumbers.add(i);
        }

        return allNumbers;
    }

    List<Integer> generateNumber();
}
