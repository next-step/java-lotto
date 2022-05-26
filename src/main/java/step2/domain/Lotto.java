package step2.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

    private static final int MARBLE_CNT = 6;

    private List<Ticket> tickets;

    public Lotto(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public Lotto(int cnt) {
        this(makeTickets(cnt));
    }

    private static List<Ticket> makeTickets(int cnt) {

        List<Ticket> tickets = new ArrayList<>();
        for (int i = 0; i < cnt; i++) {
            tickets.add(new Ticket());
        }
        return tickets;
    }

    public Statistics getStatistics(String str){
        int[] statistic = new int[7];

        int[] winningNums = toInts(str);
        for (Ticket ticket : tickets) {
           int matchCnt = ticket.getEachStatistics(winningNums);
           statistic[matchCnt]++;
        }
        return new Statistics(statistic);
    }

    private int[] toInts(String str) {
        String[] split = str.split(",");

        int[] winningNums = new int[MARBLE_CNT];
        for (int i = 0; i < MARBLE_CNT; i++) {
            winningNums[i] = Integer.parseInt(split[i].trim());
        }
        return winningNums;
    }

    public void print() {
        tickets.forEach(ticket -> System.out.println(ticket));
    }
}
