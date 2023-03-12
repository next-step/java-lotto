package lotto.service;

import lotto.domain.LottoNumber;
import lotto.view.LottoMessage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {

    private static final int LOTTO_NUMBER_MINIMUM = 1;
    private static final int LOTTO_NUMBER_MAXIMUM = 45;
    private LottoNumber lottoNumberList;

    public LottoMachine(){
        lottoNumberList = new LottoNumber(lottoNumberSetting());
        new LottoMessage(lottoNumberList).getLottoMessage();
    }

    public LottoNumber getLottoNumberList(){
        return lottoNumberList;
    }

    public List<Integer> lottoNumberSetting(){
        List<Integer> lottoNumberList = new ArrayList<Integer>();
        for(int i = LOTTO_NUMBER_MINIMUM; i <= LOTTO_NUMBER_MAXIMUM; i++){
            lottoNumberList.add(i);
        }
        Collections.shuffle(lottoNumberList);
        return lottoNumberList.subList(0, 6);
    }
}
