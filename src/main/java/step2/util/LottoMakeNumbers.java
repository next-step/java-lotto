package step2.util;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import step2.exception.LottoNotNumberException;
import step2.model.Lotto;
import step2.model.LottoNumber;

public class LottoMakeNumbers {

    private LottoMakeNumbers() {
    }

    private static final String DELIMETER = ",";

    private static final List<Integer> numbers = IntStream
        .rangeClosed(LottoNumber.MIN, LottoNumber.MAX)
        .boxed()
        .collect(toList());

    public static Lotto getRandomNumber() {
        Collections.shuffle(numbers);

        return numbers.stream()
            .limit(Lotto.SIZE)
            .map(LottoNumber::of)
            .collect(collectingAndThen(toList(), Lotto::of));
    }

    public static List convertStringToNumbers(String inputWinnerNumbers) {
        try {
            return Stream.of(inputWinnerNumbers.split(DELIMETER))
                .map(String::trim)
                .map(Integer::parseInt)
                .map(LottoNumber::of)
                .collect(toList());

        } catch (NumberFormatException e) {
            throw new LottoNotNumberException();
        }
    }
}