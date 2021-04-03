package lotto.domain.Dto;

public class RankCountDto {
    private final int matchedCountStandard;
    private final boolean hasBonus;
    private final int prize;
    private final int matchedCountAfterComparison;

    public RankCountDto(int matchedCountStandard, boolean hasBonus, int prize, int matchedCountAfterComparison) {
        this.matchedCountStandard = matchedCountStandard;
        this.hasBonus = hasBonus;
        this.prize = prize;
        this.matchedCountAfterComparison = matchedCountAfterComparison;
    }

    public int matchedCountStandard() {
        return matchedCountStandard;
    }

    public boolean hasBonus() {
        return hasBonus;
    }

    public int prize() {
        return prize;
    }

    public int matchedCountAfterComparison() {
        return matchedCountAfterComparison;
    }
}
