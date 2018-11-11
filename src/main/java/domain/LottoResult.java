package domain;

import java.util.List;

import static java.util.Arrays.asList;

public class LottoResult {

    private List<Jackpot> jackpots;

    public LottoResult(List<Jackpot> jackpots) {
        this.jackpots = jackpots;
    }

    public int matchNumberCount(Jackpot selectedJackpot) {
        return (int) jackpots.stream()
                .filter(jackpot -> jackpot.equals(selectedJackpot))
                .count();
    }

    public List<Jackpot> getJackpot() {
        return asList(Jackpot.SAME_3_NUMBERS,
                Jackpot.SAME_4_NUMBERS,
                Jackpot.SAME_5_NUMBERS,
                Jackpot.SAME_6_NUMBERS);
    }
}
