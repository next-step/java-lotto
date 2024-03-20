package lotto.domain;

public enum RankMatches {
    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000),
    NONE(0, 0);

    private static int MINIMUM_OF_PRIZE = 3;
    private int count;
    private int prize;

    RankMatches(int count, int prize){
        this.count = count;
        this.prize = prize;
    }

    public static RankMatches makeRank(int count){
        for(RankMatches rankMatches : values()){
            if(count < MINIMUM_OF_PRIZE){
                return NONE;
            }
            if(rankMatches.count == count){
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
