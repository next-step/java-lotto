package lotto.auto.model;

import lotto.auto.strategy.LottoRule;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static lotto.auto.context.ConstantContext.EARNINGS_RATE_KEY;
import static lotto.auto.context.ConstantContext.MATCH_TABLE_KEY;

public final class LottoMachine {
    private final TicketMaster ticketMaster;

    private LottoMachine(final LottoRule lottoRule) {
        this.ticketMaster = TicketMaster.init(lottoRule);
    }

    public static LottoMachine from(final LottoRule lottoRule) {
        return new LottoMachine(lottoRule);
    }

    public List<LottoGame> ticketing(final int money) {
        return ticketMaster.ticketing(money);
    }

    public Map<String, Object> producingStatistic(final int[] numbers, final List<LottoGame> lottoGames) {
        validate(numbers);
        return getStringObjectHashMap(numbers, GameAnalyzer.from(lottoGames));
    }

    private HashMap<String, Object> getStringObjectHashMap(final int[] numbers, final GameAnalyzer analyzer) {
        int[] matchTable = analyzer.getMatchTable(numbers);
        double earningsRate = analyzer.calculateEarningsRate(matchTable);
        return new HashMap<>(Map.of(MATCH_TABLE_KEY, matchTable, EARNINGS_RATE_KEY, earningsRate));
    }

    private void validate(final int[] numbers) {
        if (numbers.length != 6) {
            throw new IllegalArgumentException("there must be 6 numbers.");
        }
    }
}
