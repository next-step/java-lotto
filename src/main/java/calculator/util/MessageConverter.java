package calculator.util;

import calculator.domain.Input;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by seungwoo.song on 2022-10-05
 */
public class MessageConverter {
    private static final String SEPARATOR = " ";

    private MessageConverter() {
    }

    public static List<Input> convert(String inputs) {
        return Arrays.stream(inputs.split(SEPARATOR))
                .filter(MessageConverter::isNotEmpty)
                .map(Input::new)
                .collect(Collectors.toList());
    }

    private static boolean isNotEmpty(String input) {
        return input != null && !input.isEmpty();
    }
}
