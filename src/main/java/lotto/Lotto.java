package lotto;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    private static final int SIZE = 6;
    private static final int RANDOM_NUM_MAX = 45;
    private static final int RANDOM_NUM_MIN = 1;
    private List<Ticket> tickets = new ArrayList<>();
    private static List<Integer> lotteryNums = IntStream.rangeClosed(RANDOM_NUM_MIN, RANDOM_NUM_MAX).boxed().collect(Collectors.toList());

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
        Collections.shuffle(lotteryNums);
        return lotteryNums.stream()
                .limit(SIZE)
                .collect(Collectors.toList());
    }

    public List<Ticket> getTickets() {
        return tickets;
    }
}
