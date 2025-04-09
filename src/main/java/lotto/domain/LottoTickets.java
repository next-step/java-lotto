package lotto.domain;

import lotto.factory.LottoFactory;
import lotto.strategy.LottoStrategy;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoTickets {
    public static final int LOTTO_PRICE = 1000;
    private final List<LottoTicket> lottoTickets;


    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public static LottoTickets fromNumbers(int count, LottoStrategy lottoStrategy) {
        List<LottoTicket> tickets = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            tickets.add(LottoTicket.generateLottoNumbers(lottoStrategy));
        }
        return new LottoTickets(tickets);
    }

    public static LottoTickets purchase(int payment, int manualCount, List<String> manualLottoInputs, LottoStrategy lottoStrategy) {
        int count = payment / LOTTO_PRICE;
        validLottoTickets(payment, manualCount);
        LottoTickets manualTickets = LottoFactory.createTickets(manualLottoInputs);
        LottoTickets autoTickets = fromNumbers(count - manualCount, lottoStrategy);
        return LottoTickets.merge(manualTickets, autoTickets);
    }

    public static LottoTickets merge(LottoTickets manualLottoTickets, LottoTickets autoLottoTickets) {
        // 두 LottoTickets 객체의 내부 리스트를 가져와 병합
        List<LottoTicket> merged = new ArrayList<>(manualLottoTickets.getLottoTickets());
        merged.addAll(autoLottoTickets.getLottoTickets());

        // 병합된 리스트로 새로운 LottoTickets 객체 생성
        return new LottoTickets(merged);
    }

    private static void validLottoTickets(int totalPrice, int manualLottoCount) {
        int totalCount = totalPrice / LottoTickets.LOTTO_PRICE;
        if (totalCount < manualLottoCount) {
            throw new IllegalArgumentException(
                    "수동으로 구매하려는 로또 개수가 총 구매 가능한 개수를 초과했습니다."
            );
        }
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }

    public int getCount() {
        return lottoTickets.size();
    }

    private Map<Rank, Integer> initializeResults() {
        // Rank의 모든 값을 초기화하여 결과 맵 생성
        Map<Rank, Integer> results = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            results.put(rank, 0);
        }
        return results;
    }

    public GameResult match(WinningLottoTicket winningTicket) {
        Map<Rank, Integer> results = initializeResults();
        lottoTickets.stream()
                .map(ticket -> Rank.getRankByMatchCount(winningTicket.matchLottoNumbers(ticket), winningTicket.hasBonusMatch(ticket)))
                .forEach(rank -> results.merge(rank, 1, Integer::sum));
        return new GameResult(results, calculateReturnRate(results));
    }

    private double calculateReturnRate(Map<Rank, Integer> results) {
        int totalSpent = lottoTickets.size() * LOTTO_PRICE; // 로또 구매 비용 계산
        int totalWon = results.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getWinningMoney() * entry.getValue())
                .sum();
        return (double) totalWon / totalSpent;
    }
}
