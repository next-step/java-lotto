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
     * 무작위로 정의되는 번호의 범위
     */
    private static final int NUMBER_BOUNDARY = 45;

    /**
     * 번호 갯수
     */
    private static final int NUMBER_SIZE = 6;

    /**
     * 번호 목록
     */
    private static final List<Integer> COLLECT = IntStream.rangeClosed(1, NUMBER_BOUNDARY)
            .boxed()
            .collect(Collectors.toList());

    /**
     * 장당 티켓의 가격
     */
    private static final int TICKET_PRICE = 1000;

    private TicketSellingMachine() {}

    /**
     * 금액을 기준으로 티켓을 발권한다.
     * 티켓 한장의 가격은 1000원이다.
     *
     * @param money
     * @return
     */
    public static final List<Ticket> buy(final int money) {
        return Stream.generate(TicketSellingMachine::ticketing)
                .limit(getCount(money))
                .collect(Collectors.toList());
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
    private static final int[] createNumbers() {
        // 생성된 번호 목록을 섞는다.
        Collections.shuffle(COLLECT);

        return COLLECT.stream()
                .limit(NUMBER_SIZE)
                .mapToInt(Integer::intValue)
                .toArray();
    }

    /**
     * 금액을 기준으로 발권할 수 있는 티켓의 갯수를 반환한다.
     *
     * @param money
     * @return
     */
    private static final int getCount(final int money) {
        return money / TICKET_PRICE;
    }
}
