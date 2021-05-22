package kr.insup.lotto.utils;

import kr.insup.lotto.config.LottoConfig;

import java.util.ArrayList;
import java.util.List;

public interface NumberGenerator {

    static List<String> allNumbers() {
        List<String> allNumbers = new ArrayList<>();
        for (int i = LottoConfig.MIN_NUMBER; i < LottoConfig.MAX_NUMBER; i++) {
            allNumbers.add(String.valueOf(i));
        }
        return allNumbers;
    }

    List<String> generateNumber();
}
