package lotto.tool;

import java.util.List;
import java.util.stream.Collectors;

import lotto.exceptions.InvalidPatternException;

public final class TicketTokenizer {

    private TicketTokenizer() {
    }

    public static List<Integer> tokenize(String text) {
        if (Tokenizer.isEmpty(text)) {
            throw new InvalidPatternException();
        }
        return mapInteger(Tokenizer.captureNumbers(text));
    }

    private static List<Integer> mapInteger(List<String> numbers) {
        return numbers.stream().map(Integer::parseInt).collect(Collectors.toList());
    }

}
