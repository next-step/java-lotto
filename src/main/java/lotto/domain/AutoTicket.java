package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AutoTicket {

    private static final Integer FROM_INDEX = 0;
    private static final Integer TO_INDEX = 6;
    private static final Integer TICKET_MINIMUM_NUMBER = 1;
    private static final Integer TICKET_MAXIMUM_NUMBER = 45;

    private static final List<Integer> TICKET_NUMBER = IntStream
        .rangeClosed(TICKET_MINIMUM_NUMBER, TICKET_MAXIMUM_NUMBER)
        .boxed()
        .collect(Collectors.toCollection(ArrayList::new));

    private AutoTicket() {
    }

    public static List<Integer> ticket() {
        Collections.shuffle(TICKET_NUMBER);
        return new ArrayList<>(TICKET_NUMBER.subList(FROM_INDEX, TO_INDEX));
    }

}
