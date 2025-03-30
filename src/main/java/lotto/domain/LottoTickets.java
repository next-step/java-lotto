package lotto.domain;

import java.util.*;

public class LottoTickets {
    List<LottoTicket> tickets;

    public LottoTickets() {
        this.tickets = new ArrayList<>();
    }

    public void add(LottoTicket ticket) {
        tickets.add(ticket);
    }

    public List<LottoTicket> getTickets() {
        return tickets;
    }

    public int size() {
        return tickets.size();
    }

    public SummaryReport getSummary(LottoTicket winningTicket, int bonusNumber) {
        List<LottoResult> results = new ArrayList<>();
        for (LottoTicket ticket : tickets) {
            results.add(ticket.matchWinner(winningTicket, bonusNumber));
        }

        Map<PrizeRank, Integer> summary = new HashMap<>();
        for (LottoResult result : results) {
            summary.put(result.getRank(), summary.getOrDefault(result.getRank(), 0) + 1);
        }

        return new SummaryReport(summary);
    }

    public static LottoTickets generate(int autoCount) {
        return generate(List.of(), autoCount);
    }

    public static LottoTickets generate(List<int[]> manualNumbers) {
        return generate(manualNumbers, 0);
    }

    public static LottoTickets generate(List<int[]> manualNumbers, int autoCount) {
        LottoTickets allTickets = new LottoTickets();

        for (int i = 0; i < manualNumbers.size(); i++) {
            int[] numbers = manualNumbers.get(i);
            try {
                allTickets.add(LottoTicketGenerator.manual(numbers));
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException((i + 1) + "번째 수동 번호" + Arrays.toString(numbers) + "가 유효하지 않습니다 - " + e.getMessage());
            }
        }

        for (int i = 0; i < autoCount; i++) {
            allTickets.add(LottoTicketGenerator.auto());
        }
        return allTickets;
    }
}