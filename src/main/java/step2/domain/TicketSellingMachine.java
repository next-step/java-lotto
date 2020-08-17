package step2.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 로또를 구매 할 수 있는 기능을 정의
 */
public class TicketSellingMachine {

    /**
     * 번호 목록
     */
    private static final List<Integer> COLLECT = IntStream.rangeClosed(LottoNumber.MIN_NUMBER, LottoNumber.MAX_NUMBER)
            .boxed()
            .collect(Collectors.toList());

    /**
     * 장당 티켓의 가격
     */
    public static final int TICKET_PRICE = 1000;

    private TicketSellingMachine() {
    }

    /**
     * 금액을 기준으로 티켓을 발권한다.
     * 티켓 한장의 가격은 1000원이다.
     *
     * @param wallet
     * @return
     */
    public static final Receipt buy(final Wallet wallet) {
        int ticketCount = getCount(wallet);
        wallet.spend(ticketCount * TICKET_PRICE);

        return new Receipt(
                wallet.getMoney(),
                Stream.generate(TicketSellingMachine::ticketing)
                        .limit(ticketCount)
                        .collect(Collectors.toList()));
    }

    /**
     * 금액을 기준으로 발권할 수 있는 티켓의 갯수를 반환한다.
     *
     * @param wallet
     * @return
     */
    private static final int getCount(final Wallet wallet) {
        return wallet.getMoney() / TICKET_PRICE;
    }

    /**
     * 금액과 입력 번호 목록을 기준으로 티켓을 발권한다.
     * 티켓 한장의 가격은 1000원이다.
     *
     * @param wallet
     * @param numbers
     * @return
     */
    public static Receipt buy(final Wallet wallet, List<List<Integer>> numbers) {
        List<Ticket> tickets = numbers.stream()
                .map(TicketSellingMachine::ticketing)
                .collect(Collectors.toList());

        wallet.spend(tickets.size() * TICKET_PRICE);

        return new Receipt(wallet.getMoney(), tickets);
    }

    /**
     * 티켓을 발행한다.
     *
     * @param numbers
     * @return
     */
    public static final Ticket ticketing(List<Integer> numbers) {
        return new Ticket(numbers);
    }

    /**
     * 티켓을 발행한다.
     *
     * @return
     */
    public static final Ticket ticketing() {
        return new Ticket(createNumbers());
    }

    /**
     * 번호 목록을 생성하여 반환한다.
     *
     * @return
     */
    private static final List<Integer> createNumbers() {
        // 생성된 번호 목록을 섞는다.
        Collections.shuffle(COLLECT);

        return COLLECT.stream()
                .limit(LottoNumbers.SIZE)
                .collect(Collectors.toList());
    }
}
