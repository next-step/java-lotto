package calculator.util;

import calculator.domain.InputValue;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by seungwoo.song on 2022-10-04
 */
public class MessageConverter {

    public static final String SEPARATOR = " ";

    public List<InputValue> convert(String input) {
        return Arrays.stream(input.split(SEPARATOR))
                .map(String::trim)
                .filter(StringUtils::isNotBlank)
                .map(InputValue::new)
                .collect(Collectors.toList());
    }
}
