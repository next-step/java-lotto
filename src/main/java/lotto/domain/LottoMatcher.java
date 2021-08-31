package lotto.domain;

import lotto.exception.InvalidNumberException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoMatcher {
    private List<Lotto> lottos;
    private Lotto lastWeekNumbers;

    public LottoMatcher(List<Lotto> lottos, String lastWeekNumbers) {
        this.lottos = lottos;
        askInvalidNumber(lastWeekNumbers);

        this.lastWeekNumbers = new Lotto(lastWeekNumbers);
    }

    public Map<LottoRank, Integer> matchWinning() {
        Map<LottoRank, Integer> ranks = new HashMap<>();
        for (Lotto lotto : lottos) {
            int matchCount = lotto.askMatchCount(lastWeekNumbers);
            LottoRank lottoRank = LottoRank.findByMatchCount(matchCount);
            ranks.put(lottoRank, ranks.getOrDefault(lottoRank, 0) + 1);
        }
        return ranks;
    }

    private void askInvalidNumber(String lastWeekNumbers) {
        String[] lastWeekNumber = lastWeekNumbers.split(",");
        for (int i = 0; i < lastWeekNumbers.split(",").length; i++) {
            checkInvalidNumber(Integer.parseInt(lastWeekNumber[i]));
        }
    }

    private void checkInvalidNumber(int lastWeekNumber) {
        if (lastWeekNumber < LottoNumber.MIN_NUMBER || lastWeekNumber > LottoNumber.MAX_NUMBER) {
            throw new InvalidNumberException();
        }
    }
}
