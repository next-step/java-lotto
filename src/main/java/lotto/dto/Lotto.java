package lotto.dto;

import lotto.utils.LottoMaker;

import java.util.List;

public class Lotto {

    private List<Integer> frameNumber;

    public Lotto() {
        this.frameNumber = LottoMaker.getSixNumsAfterShuffle(LottoMaker.getOnetoFortyFive());
    }

    public List<Integer> getLotto() {
        return frameNumber;
    }






}
