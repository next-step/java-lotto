package lotto.domain;

import common.StringResources;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TicketTest {

    @Test
    public void makeLottoNumberSuccess() {

        List<Integer> fullNumberList = Stream.iterate(1, i -> i + 1)
                .limit(45)
                .collect(Collectors.toList());

        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            Collections.shuffle(fullNumberList, random);

            List<Integer> numbers = fullNumberList.subList(0, 6);
            Collections.sort(numbers);
            assertThat(new Ticket(numbers)).isNotNull();
        }
    }

    @Test
    public void wrongRangeNumbers() {

        List<Integer> hasTooSmallValueList = Arrays.asList(0, 1, 2, 3, 4, 5);
        List<Integer> hasTooLargeValueList = Arrays.asList(46, 1, 2, 3, 4, 5);

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Ticket(hasTooSmallValueList))
                .withMessage(StringResources.ERR_WRONG_RANGE_NUMBER);

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Ticket(hasTooLargeValueList))
                .withMessage(StringResources.ERR_WRONG_RANGE_NUMBER);
    }

    @Test
    public void duplicateNumbers() {

        List<Integer> hasDuplicatedNumberList = Arrays.asList(1, 1, 2, 3, 4, 5);

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Ticket(hasDuplicatedNumberList))
                .withMessage(StringResources.ERR_DUPLICATE_NUMBER);
    }

    @Test
    public void tooFewItems() {

        List<Integer> tooManyItems = Arrays.asList(1, 2, 3, 4, 5);

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Ticket(tooManyItems))
                .withMessage(StringResources.ERR_DUPLICATE_NUMBER);
    }

    @Test
    public void tooManyItems() {

        List<Integer> tooManyItems = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Ticket(tooManyItems))
                .withMessage(StringResources.ERR_DUPLICATE_NUMBER);
    }

    @Test
    public void toStringTest() {

        Ticket ticket = RandomLottoCreator.createTicket();
        int[] numbers = ticket.getNumbers().stream().mapToInt(Integer::intValue).toArray();

        String toStringText = ticket.toString();

        assertEquals(toStringText.charAt(0), '[');
        assertEquals(toStringText.charAt(toStringText.length() - 1), ']');

        String numbersText = toStringText.substring(1, toStringText.length() - 1);
        String[] stringNumbers = numbersText.split(", ");

        assertEquals(numbers.length, stringNumbers.length);

        for (int i = 0; i < numbers.length; i++) {
            assertEquals(numbers[i], Integer.parseInt(stringNumbers[i]));
        }
    }
}
