package domain;

import java.util.List;

import static domain.LottoGenerator.DRAW_NUMBER_COUNT;

public class Lotto {
    public static final int PRICE_PER_ONE = 1000;

    private final List<Integer> numList;
    private Rank rank;

    public Lotto(List<Integer> numList){
        if(numList == null || numList.isEmpty()){
            throw new IllegalArgumentException("numList가 null이거나 비어있을수 없습니다.");
        }

        if(numList.size() != DRAW_NUMBER_COUNT){
            throw new IllegalArgumentException("numList의 size가 잘못되었습니다. numList.size() : " + numList.size());
        }
        this.numList = numList;
    }

    public Lotto(List<Integer> numList, List<Integer> winningNums, BonusNumber bonusNumber){
        this(numList);
        this.matchRank(winningNums, bonusNumber);
    }


    public List<Integer> getNumList(){
        return numList;
    }

    public void matchRank(List<Integer> winningNums, BonusNumber bonusNumber){
        int countOfMatch = (int) this.numList.stream()
            .filter(winningNums::contains)
            .count();

        boolean matchBonus = bonusNumber.isMatch(this);

        this.rank = Rank.valueOf(countOfMatch, matchBonus);
    }

    public Rank getRank() {
        return rank;
    }
}
