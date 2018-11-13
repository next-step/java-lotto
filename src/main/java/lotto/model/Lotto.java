package lotto.model;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    private static final int SIZE = 6;

    private static List<LottoNum> lotteryNums = IntStream.rangeClosed(LottoNum.RANDOM_NUM_MIN, LottoNum.RANDOM_NUM_MAX)
            .mapToObj(LottoNum::new)
            .collect(Collectors.toList());
    private List<Ticket> tickets = new ArrayList<>();


    public Lotto(Amount amount, List<Ticket> manualTickets) {
        tickets.addAll(manualTickets);
        createTickets(amount);
    }

    /**
     * 티켓 생성
     *
     * @param amount
     */
    private void createTickets(Amount amount) {
        while(amount.canPurcharse(1)) {
            amount.purcharseTicket(1);
            Ticket ticket = new Ticket(makeRandNums(), true);
            tickets.add(ticket);
        }
    }

    /**
     * 랜덤 숫자 생성
     *
     * @return
     */
    private List<LottoNum> makeRandNums() {
        Collections.shuffle(lotteryNums);
        return lotteryNums.stream()
                .limit(SIZE)
                .collect(Collectors.toList());
    }

    public List<Ticket> getTickets() {
        return tickets;
    }
}
