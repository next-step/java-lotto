package lotto;

import java.util.ArrayList;
import java.util.List;

import lotto.enums.ErrorMessage;
import lotto.exceptions.InvalidPatternException;

public final class TicketTokenizer {

    private TicketTokenizer() {
    }

    public static List<Integer> tokenize(String text) {
        if (Tokenizer.isEmpty(text)) {
            throw new InvalidPatternException(ErrorMessage.INVALID_PATTERN.toString());
        }
        return mapInteger(Tokenizer.captureNumbers(text));
    }

    private static List<Integer> mapInteger(List<String> numbers) {
        List<Integer> result = new ArrayList<>();
        for (String number : numbers) {
            result.add(Integer.parseInt(number));
        }
        return result;
    }

}
