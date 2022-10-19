package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {

    private static final int TICKET_AMOUNT = 1000;
    public static final int THREE_MATCH_RANK_REWARD = 5000;
    public static final int FOUR_MATCH_RANK_REWARD = 50000;
    public static final int FIVE_MATCH_RANK_REWARD = 1500000;
    public static final int SIX_MATCH_RANK_REWARD = 2000000000;
    private final List<Ticket> ticketList;
    private int threeMatchRankCount = 0;
    private int fourMatchRankCount = 0;
    private int fiveMatchRankCount = 0;
    private int sixMatchRankCount = 0;


    public Lotto(int amount) {
        int ticketCount = convertAmountToTicketCount(amount);
        this.ticketList = makeTicketList(ticketCount);
    }

    public Lotto(List<Ticket> ticketList) {
        this.ticketList = ticketList;
    }

    public static int convertAmountToTicketCount(int amount) {
        return amount / TICKET_AMOUNT;
    }

    public static List<Ticket> makeTicketList(int count) {
        List<Ticket> ticketList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Ticket ticket = new Ticket();
            ticketList.add(ticket);
        }
        return ticketList;
    }

    public int getTicketCount() {
        return ticketList.size();
    }

    public List<Ticket> getTicketList() {
        return ticketList;
    }

    public void rankedWinningNumbers(List<Integer> winningNumbers) {
        for (Ticket ticket : ticketList) {
            int matchCount = getWinningNumbersMatchCount(winningNumbers, ticket);
            increaseRankMatchCount(matchCount);
        }
    }


    public void increaseRankMatchCount(int matchCount) {
        if (matchCount == 3) {
            threeMatchRankCount++;
            return;
        }
        if (matchCount == 4) {
            fourMatchRankCount++;
            return;
        }
        if (matchCount == 5) {
            fiveMatchRankCount++;
            return;
        }
        if (matchCount == 6) {
            sixMatchRankCount++;
        }
    }

    public static int getWinningNumbersMatchCount(List<Integer> winningNumbers, Ticket ticket) {
        int matchCount = 0;
        for (Integer tiketNumber : ticket.getLottoNumbers()) {
            matchCount = increaseMatchCount(winningNumbers, tiketNumber, matchCount);
        }
        return matchCount;
    }

    public static int increaseMatchCount(List<Integer> winningNumbers, Integer tiketNumber, int matchCount) {
        if (winningNumbers.contains(tiketNumber)) {
            matchCount++;
        }
        return matchCount;
    }

    public int getThreeMatchRankCount() {
        return threeMatchRankCount;
    }

    public int getFourMatchRankCount() {
        return fourMatchRankCount;
    }

    public int getFiveMatchRankCount() {
        return fiveMatchRankCount;
    }

    public int getSixMatchRankCount() {
        return sixMatchRankCount;
    }

    public double caculateIncomePercentage(){
        int purchageAmount = ticketList.size() * TICKET_AMOUNT;
        return  getTotalWinningAmount() / (double)purchageAmount;
    }

    public int getTotalWinningAmount() {
        return threeMatchRankCount * THREE_MATCH_RANK_REWARD
                + fourMatchRankCount * FOUR_MATCH_RANK_REWARD
                + fiveMatchRankCount * FIVE_MATCH_RANK_REWARD
                + sixMatchRankCount * SIX_MATCH_RANK_REWARD;
    }
}
