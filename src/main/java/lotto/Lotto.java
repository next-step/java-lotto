package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private List<Integer> lottoNumberList;
    private static final int LOTTO_COUNT = 6;

    public List<Integer> Lotto(List<Integer> lottoNumbers){
        Collections.shuffle(lottoNumbers);
        for (int i = 0; i < LOTTO_COUNT; i++) {
            lottoNumberList.add(lottoNumbers.get(i));
        }
        Collections.sort(lottoNumberList);
        System.out.println(lottoNumberList);
        return lottoNumberList;
    }
}