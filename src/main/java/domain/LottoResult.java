package domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class LottoResult {

    private List<Jackpot> jackpots;

    public LottoResult(List<Jackpot> jackpots) {
        this.jackpots = jackpots;
    }

    public int matchCount(Jackpot selectedJackpot) {
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

    public double calculatorRate() {
        int totalPrizeMoney = getTotalPrizeMoney();
        double rate = (double)totalPrizeMoney / getPaidLotto();
        return new BigDecimal(rate)
                .setScale(2, RoundingMode.DOWN)
                .doubleValue();
    }

    private int getPaidLotto() {
        return Lotto.PRICE * jackpots.size();
    }

    private int getTotalPrizeMoney() {
        int totalPrizeMoney = 0;
        for (Jackpot jackpot : getJackpot()) {
            totalPrizeMoney += jackpot.getTotalPrizeMoney(matchCount(jackpot));
        }
        return totalPrizeMoney;
    }
}
