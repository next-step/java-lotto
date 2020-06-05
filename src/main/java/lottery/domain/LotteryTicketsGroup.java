package lottery.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LotteryTicketsGroup {

    private static final int DEFAULT_WINNER_TICKET_COUNTS = 0;
    private static final int COUNT_ZERO = 0;
    private static final int COUNT_ONE = 1;
    private final List<LotteryTicket> lotteryTickets;

    private LotteryTicketsGroup(List<LotteryTicket> lotteryTickets) {
        this.lotteryTickets = lotteryTickets;
    }

    public static LotteryTicketsGroup from(List<LotteryTicket> lotteryTickets) {
        return new LotteryTicketsGroup(lotteryTickets);
    }

    public static LotteryTicketsGroup publishLotteryTicketsGroup(PurchasePrice purchasePrice,
                                                                 ManualTicketsNumbersDto manualTicketsNumbersDto) {
        if (purchasePrice.getManualTicketCounts() == COUNT_ZERO) {
            return new LotteryTicketsGroup(publishOnlyAutomaticLotteryTicketsGroup(purchasePrice));
        }
        return new LotteryTicketsGroup(publishMixedLotteryTicketsGroup(purchasePrice, manualTicketsNumbersDto));
    }

    private static List<LotteryTicket> publishOnlyAutomaticLotteryTicketsGroup(PurchasePrice purchasePrice) {
        return Stream.generate(LotteryTicket::publishAutomaticLotteryTicket)
                .limit(purchasePrice.getAutomaticTicketCounts())
                .collect(Collectors.toList());
    }

    private static List<LotteryTicket> publishMixedLotteryTicketsGroup(PurchasePrice purchasePrice,
                                                                       ManualTicketsNumbersDto manualTicketsNumbersDto) {
        Stream<LotteryTicket> manualTicketsStream = manualTicketsNumbersDto.getManualTicketsNumbers()
                .stream()
                .map(LotteryTicket::publishManualLotteryTicket);
        Stream<LotteryTicket> autoTicketsStream = Stream.generate(LotteryTicket::publishAutomaticLotteryTicket)
                .limit(purchasePrice.getAutomaticTicketCounts());
        return Stream.concat(manualTicketsStream, autoTicketsStream)
                .collect(Collectors.toList());
    }

    public List<List<Integer>> getLotteryTicketsNumbers() {
        return lotteryTickets.stream()
                .map(LotteryTicket::getLotteryNumbers)
                .collect(Collectors.toList());
    }

    public Map<LotteryRank, Integer> findWinnerTicketCountsByRank(LotteryTicket lastWinnerTicket,
                                                                  BonusBall bonusBall) {
        Map<LotteryRank, Integer> gameResultBoard = new HashMap<>();
        lotteryTickets.stream()
                .map(targetLotteryTicket -> targetLotteryTicket.getMatchLotteryRank(lastWinnerTicket, bonusBall))
                .forEach(targetLotteryRank -> updateGameResultBoard(targetLotteryRank, gameResultBoard));
        return gameResultBoard;
    }

    private void updateGameResultBoard(LotteryRank lotteryRank, Map<LotteryRank, Integer> gameResultBoard) {
        int winnerTicketCounts = gameResultBoard.getOrDefault(lotteryRank, DEFAULT_WINNER_TICKET_COUNTS)
                + COUNT_ONE;
        gameResultBoard.put(lotteryRank, winnerTicketCounts);
    }
}
