package lotto.domain;

public enum RankMatches {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0);

    private static int MINIMUM_OF_PRIZE = 3;
    private int count;
    private int prize;

    RankMatches(int count, int prize){
        this.count = count;
        this.prize = prize;
    }

    public static RankMatches makeRank(int count, boolean bonusNum){
        for(RankMatches rankMatches : values()){
            if(count < MINIMUM_OF_PRIZE){
                return NONE;
            }
            if(SECOND.count == count && bonusNum){
                return SECOND;
            }
            if(rankMatches.count == count && rankMatches!=SECOND){
                return rankMatches;
            }
        }
        throw new IllegalArgumentException("알수없는 인풋");
    }


    public int getCount(){
        return count;
    }

    public int getPrize(){
        return prize;
    }
}
