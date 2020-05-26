package lottery.domain;

import lottery.view.ViewMessages;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringParser {

    private StringParser() {
    }

    public static List<LotteryNumber> parseString(String userInput) {
        return Arrays.stream(userInput.split(ViewMessages.COMMA))
                .map(number -> new LotteryNumber(Integer.parseInt(number)))
                .collect(Collectors.toList());
    }
}
