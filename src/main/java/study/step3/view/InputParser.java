package study.step3.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import study.step3.domain.exception.LottoException;

public class InputParser {

    public static List<Integer> parse(String string) {
        String[] split = string.split(",");
        try {
            return Arrays.stream(split)
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new LottoException("로또 번호는 숫자를 입력해야 합니다.");
        }
    }
}
