package lotto;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import lotto.enums.Message;
import lotto.enums.Prize;
import lotto.views.Display;

public class LottoSponsor {

    private Map<Prize, Integer> scores;
    private long totalPrizeMoney;
    private float earningRate;

    public LottoSponsor(List<Ticket> tickets, Ticket winningTicket, Purchase purchase) {
        Map<Prize, Integer> scores = countScores(tickets, winningTicket);
        long totalPrizeMoney = sumPrizeMoney(scores);
        float earningRate = convertToEarningRate(totalPrizeMoney, purchase.payment());

        this.scores = scores;
        this.totalPrizeMoney = totalPrizeMoney;
        this.earningRate = earningRate;
    }

    protected Map<Prize, Integer> countScores(List<Ticket> tickets, Ticket winningTicket) {
        Map<Prize, Integer> scores = new EnumMap<>(Prize.class);
        for (Prize prize : Prize.values()) {
            scores.put(prize, 0);
        }

        for (Ticket ticket : tickets) {
            int index = ticket.countSameNumbers(winningTicket);
            Prize key = Prize.valueOf(index);
            int score = scores.get(key) + 1;
            scores.put(key, score);
        }
        return scores;
    }

    protected long sumPrizeMoney(Map<Prize, Integer> scores) {
        long sum = 0;

        for (Prize prize : scores.keySet()) {
            long money = (long)prize.getPrize() * (long)scores.get(prize);
            sum += money;
        }

        return sum;
    }

    protected float convertToEarningRate(long totalPrizeMoney, int payment) {
        return (float)(Math.floor(totalPrizeMoney / (float)payment * 100) / 100.0);
    }

    public void show() {
        Display.show(Message.RESULT_HEAD);
        Display.show(Message.RESULT_3, this.scores.get(Prize.THREE));
        Display.show(Message.RESULT_4, this.scores.get(Prize.FOUR));
        Display.show(Message.RESULT_5, this.scores.get(Prize.FIVE));
        Display.show(Message.RESULT_6, this.scores.get(Prize.SIX));
        Display.show(Message.RESULT_TOTAL, this.totalPrizeMoney);
        Display.show(Message.RESULT_TAIL, this.earningRate);
    }

}
