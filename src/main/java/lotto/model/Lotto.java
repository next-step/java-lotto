package lotto.model;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    private static final int SIZE = 6;
    private static final int RANDOM_NUM_MAX = 45;
    private static final int PRICE = 1_000;
    private static final int RANDOM_NUM_MIN = 1;
    private static List<Integer> lotteryNums = IntStream.rangeClosed(RANDOM_NUM_MIN, RANDOM_NUM_MAX)
            .boxed()
            .collect(Collectors.toList());
    private List<Ticket> tickets = new ArrayList<>();


    public Lotto(Long num) {
        createTickets(num);
    }

    /**
     * 티켓 생성
     *
     * @param buyAmount
     */
    private void createTickets(long buyAmount) {
        for (int i = 0; i < buyAmount / PRICE; i++) {
            Ticket ticket = new Ticket(makeRandNums());
            tickets.add(ticket);
        }
    }

    /**
     * 랜덤 숫자 생성
     *
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
