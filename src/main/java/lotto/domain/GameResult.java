package lotto.domain;

import lotto.enums.MatchType;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameResult {

    private List<Ticket> tickets;
    private Map<MatchType, Integer> lottoResults;

    public GameResult(List<Ticket> tickets, WinningLotto winningLotto) {
        this.tickets = tickets;
        this.lottoResults = new HashMap<>();
        generateGameResult(winningLotto);
    }

    protected void generateGameResult(WinningLotto winningLotto) {
        initializeMap();
        this.tickets.stream()
                .map(ticket -> ticket.compareWinningLotto(winningLotto))
                .forEach(this::updateResult);
    }

    private void initializeMap() {
        for (MatchType matchType : MatchType.values()) {
            lottoResults.put(matchType, 0);
        }
    }

    private void updateResult(MatchType type) {
        lottoResults.put(type, lottoResults.get(type) + 1);
    }

    public Map<MatchType, Integer> getLottoResults() {
        return lottoResults;
    }

    public BigDecimal calculateBenefitRate() {
        return Money.getBenefitRate(this.lottoResults);
    }
}
