package com.fineroot.lotto.view;

import com.fineroot.lotto.entity.LottoStore;

public class ResultView {
    private LottoStore lottoStore;

    public ResultView(LottoStore lottoStore){
        this.lottoStore = lottoStore;
    }

    public void draw(){
        System.out.println(Integer.toString(lottoStore.howMuchLotto()).concat("개를 구매했습니다."));
    }
}
