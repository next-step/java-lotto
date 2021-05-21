package kr.insup.lotto.utils;

import kr.insup.lotto.config.LottoConfig;

import java.util.*;

public class LottoAutoGenerator {

    public static List<Integer> allNumbers(){
        List<Integer> allNumbers = new ArrayList<>();
        for(int i = LottoConfig.MIN_NUMBER; i< LottoConfig.MAX_NUMBER; i++){
            allNumbers.add(i);
        }
        return allNumbers;
    }

    public static List<Integer> lottoAutoNumbers() {
        Collections.shuffle(allNumbers());
        List<Integer> lottoAutoNumbers = allNumbers().subList(0, LottoConfig.PICK_NUMBER);
        Collections.sort(lottoAutoNumbers);
        return lottoAutoNumbers;
    }
}
