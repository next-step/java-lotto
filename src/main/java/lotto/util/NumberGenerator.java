package lotto.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberGenerator {

    static final int LOTTO_START_NUM = 1;
    static final int LOTTO_END_NUM = 45;
    static final int WIN_NUM_START = 0;
    static final int WIN_NUM_END = 6;

    public List<Integer> generateSixNumbers(){
        List<Integer> baseNumbers = new ArrayList<>();
        for(int i=LOTTO_START_NUM; i<=LOTTO_END_NUM; i++){
            baseNumbers.add(i);
        }

        Collections.shuffle(baseNumbers);
        return baseNumbers.subList(WIN_NUM_START,WIN_NUM_END);
    }

}
