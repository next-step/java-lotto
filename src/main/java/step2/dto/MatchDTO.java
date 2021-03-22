package step2.dto;

public class MatchDTO {
    private final int countOfMatch;
    private final boolean matchBonus;

    public MatchDTO(int countOfMatch, boolean matchBonus){
        this.countOfMatch = countOfMatch;
        this.matchBonus = matchBonus;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public boolean getMatchBonus() {
        return matchBonus;
    }
}
