package step2.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 로또를 구매 할 수 있는 기능을 정의
 */
public class TicketSellingMachine {

    private static final Random DICE = new Random();

    /**
     * 번호 갯수
     */
    private static final int NUMBER_COUNT = 6;

    /**
     * 무작위로 정의되는 번호의 범위
     */
    private static final int NUMBER_BOUNDARY = 45;

    /**
     * 장당 티켓의 가격
     */
    private static final int TICKET_PRICE = 1000;

    private TicketSellingMachine() {
    }

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
        List<Integer> result = new ArrayList<>();

        while (result.size() < NUMBER_COUNT) {
            result.add(nextNumber(result));
        }

        // 생성된 번호 목록을 섞는다.
        Collections.shuffle(result);

        return result.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }


    /**
     * numbers 목록을 기준으로 중복되지 않는 숫자를 반환한다.
     * 숫자는 nextInt() 함수를 통해 생성한다. (숫자 범위 1 ~ 45)
     *
     * @param numbers
     * @return
     */
    private static final int nextNumber(final List<Integer> numbers) {
        int result = nextInt(NUMBER_BOUNDARY);
        boolean duplicated = checkDuplicate(numbers, result);

        while (duplicated) {
            result = nextInt(NUMBER_BOUNDARY);
            duplicated = checkDuplicate(numbers, result);
        }

        return result;
    }

    /**
     * 숫자를 반환한다.
     * 숫자 범위 1 ~ 45
     *
     * @param bound
     * @return
     */
    private static final int nextInt(final int bound) {
        return DICE.nextInt(bound) + 1;
    }

    /**
     * 숫자 목록과 숫자를 비교하여 중복된 숫자 여부를 판별한다.
     *
     * @param numbers
     * @param number
     * @return
     */
    private static final boolean checkDuplicate(final List<Integer> numbers, final int number) {
        return numbers.stream()
                .filter(value -> value == number)
                .findFirst()
                .isPresent();
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
