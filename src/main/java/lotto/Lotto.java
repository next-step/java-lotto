package lotto;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Collections.*;

public class Lotto {
    private static final int SIZE = 6;
    private static final int RANDOM_NUM_BOUND = 45;
    private static final int RANDOM_NUM_MIN = 1;
    private List<Ticket> tickets = new ArrayList<>();

    public Lotto(int num) {
        createTickets(num);
    }

    /**
     * 티켓 생성
     * @param num
     */
    private void createTickets(int num) {
        for (int i = 0; i < num; i++) {
            Ticket ticket = new Ticket(makeRandNums());
            tickets.add(ticket);
        }
    }

    /**
     * 랜덤 숫자 생성
     * @return
     */
    private List<Integer> makeRandNums() {
        return new Random().ints(SIZE, RANDOM_NUM_MIN, RANDOM_NUM_BOUND)
                        .boxed()
                        .collect(Collectors.toList());
    }

    public List<Ticket> getTickets() {
        return tickets;
    }
}
