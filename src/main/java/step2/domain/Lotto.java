package step2.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Lotto {

    private static final int MARBLE_CNT = 7;

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

    public Map<Integer, Integer> getStatic(String str){
        int[] winningNums = toInts(str);



        return null;
    }

    private int[] toInts(String str) {
        String[] split = str.split(",");

        int[] winningNums = new int[MARBLE_CNT];
        for (int i = 0; i < MARBLE_CNT; i++) {
            winningNums[i] = Integer.parseInt(split[i]);
        }
        return winningNums;
    }
}
