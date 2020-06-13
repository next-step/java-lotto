package lotto.util;

import java.util.List;
import java.util.stream.Collectors;

public class ConvertInt {

    private ConvertInt() {}

    public static int from(String text) {
        try {
            return Integer.parseInt(text);
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자로 변환할 수 없는 입력입니다.");
        }
    }

    public static List<Integer> from(List<String> text) {
        try {
            return text.stream().map(Integer::parseInt).collect(Collectors.toList());
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자로 변환할 수 없는 입력입니다.");
        }
    }

}
