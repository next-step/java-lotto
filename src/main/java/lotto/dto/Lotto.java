package lotto.dto;

import lotto.vo.LottoNum;

import java.util.Set;

public class Lotto {

    public static final int LOTTO_SIZE = 6;
    private Set<LottoNum> frameNumber;

    public Lotto(Set<LottoNum> frameNumber) {
        if(frameNumber.size() != LOTTO_SIZE){
            throw new IllegalArgumentException("Lotto has must 6 arguments size");
        }
        this.frameNumber = frameNumber;
    }

    public Set<LottoNum> getLotto() {
        return frameNumber;
    }

    /**
     * get을 안쓸 수는 없을까..
     * VO를 안쓰면 get을 써야만 할 것 같다..
     */
    public int match(Lotto boughntLotto) {
        int matchCount = 0;
        for(LottoNum lottoNum : frameNumber){
            if(boughntLotto.contains(lottoNum)){
                matchCount++;
            }
        }
        return matchCount;
    }

    public boolean contains(LottoNum bonusnum){
        return frameNumber.contains(bonusnum);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        boolean start = true;
        for(LottoNum lottoNum : frameNumber){
            if(start){
                sb.append(lottoNum.getNum());
                start = false;
                continue;
            }
            sb.append(", " + lottoNum.getNum());
        }

        return sb.toString();
    }
}
