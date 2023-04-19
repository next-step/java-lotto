package domain;

public class Rank {
    public static int of(final int matchCount, final boolean matchBonus){
        if(matchCount == 6){
            return  1;
        }
        if(matchCount == 5 && matchBonus){
            return 2;
        }
        if (matchCount > 2){
            return 6 - matchCount + 2;
        }
        return 0 ;
    }
}
