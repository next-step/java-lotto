package lotto.dto;

import lotto.utils.LottoMaker;

import java.util.List;
import java.util.Set;

public class Lotto {

    public static final int LOTTO_SIZE = 6;
    private Set<Integer> frameNumber;

    /**
     * Test용 생성자
     * 테스트하려면 필요한데...필요할까..
     * @param frameNumber
     */
    public Lotto(Set<Integer> frameNumber) {
        if(frameNumber.size() != LOTTO_SIZE){
            throw new IllegalArgumentException("Lotto has must 6 arguments size");
        }
        this.frameNumber = frameNumber;
    }

    public Set<Integer> getLotto() {
        return frameNumber;
    }

    /**
     * get을 안쓸 수는 없을까..
     * VO를 안쓰면 get을 써야만 할 것 같다..
     */
    public int match(Lotto boughntLotto) {
        int matchCount = 0;
        for ( int i = 0 ; i < frameNumber.size() ; i++ ){
            if(boughntLotto.getLotto().contains(frameNumber.toArray()[i])){
                matchCount++;
            }
        }
        return matchCount;
    }

    public boolean contains(int bonusnum){
        return frameNumber.contains(bonusnum);
    }
}
