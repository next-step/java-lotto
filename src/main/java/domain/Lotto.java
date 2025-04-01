package domain;

import java.util.List;

import static domain.LottoGenerator.DRAW_NUMBER_COUNT;

public class Lotto {
    private final List<Integer> numList;
    public static final int PRICE_PER_ONE = 1000;

    public Lotto(List<Integer> numList){
        if(numList == null || numList.isEmpty()){
            throw new IllegalArgumentException("numList가 null이거나 비어있을수 없습니다.");
        }

        if(numList.size() != DRAW_NUMBER_COUNT){
            throw new IllegalArgumentException("numList의 size가 잘못되었습니다. numList.size() : " + numList.size());
        }
        this.numList = numList;
    }

    public List<Integer> getNumList(){
        return numList;
    }
}
