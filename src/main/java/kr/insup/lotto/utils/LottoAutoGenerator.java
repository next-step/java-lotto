package kr.insup.lotto.utils;

import kr.insup.lotto.config.LottoConfig;

import java.util.*;

public class LottoAutoGenerator implements NumberGenerator {

    private List<String> lottoAutoNumbers() {
        List<String> allNumbers = NumberGenerator.allNumbers();
        Collections.shuffle(allNumbers);
        List<String> lottoAutoNumbers = allNumbers.subList(0, LottoConfig.PICK_NUMBER);
        Collections.sort(lottoAutoNumbers, Comparator.comparing(Integer::valueOf));
        return lottoAutoNumbers;
    }

    @Override
    public List<String> generateNumber() {
        return lottoAutoNumbers();
    }
}
