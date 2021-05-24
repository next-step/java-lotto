package kr.insup.lotto.utils;

import kr.insup.lotto.config.LottoConfig;

import java.util.*;

public class LottoAutoGenerator implements NumberGenerator {

    private List<Integer> lottoAutoNumbers() {
        List<Integer> allNumbers = NumberGenerator.allNumbers();
        Collections.shuffle(allNumbers);
        List<Integer> lottoAutoNumbers = allNumbers.subList(0, LottoConfig.LOTTO_COUNT);
        Collections.sort(lottoAutoNumbers, Comparator.naturalOrder());

        return lottoAutoNumbers;
    }

    @Override
    public List<Integer> generateNumber() {
        return lottoAutoNumbers();
    }
}
