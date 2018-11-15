package lotto.dto;

import lotto.utils.LottoMaker;

import java.util.List;

public class Lotto {

    private List<Integer> frameNumber;

    public Lotto() {
        this.frameNumber = LottoMaker.getSixNumsAfterShuffle(LottoMaker.getOnetoFortyFive());
    }

    /**
     * Test용 생성자
     * 테스트하려면 필요한데...필요할까..
     * @param frameNumber
     */
    public Lotto(List<Integer> frameNumber) {
        this.frameNumber = frameNumber;
    }

    public List<Integer> getLotto() {
        return frameNumber;
    }

}
