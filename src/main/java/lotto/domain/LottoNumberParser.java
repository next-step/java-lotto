package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumberParser {
    public static final String DELIMITER = ",";

    public List<Integer> parse(String expression) {
        if (StringUtils.isNullOrBlank(expression)) throw new RuntimeException("Null 또는 빈값이 입력되어습니다");
        List<String> parts = Arrays.asList(expression.split(DELIMITER));

        shouldNumber(parts);
        shouldRangeOfLottoNumber(parts);

        return parts.stream()
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

    private void shouldRangeOfLottoNumber(List<String> parts) {
        parts.forEach(this::isLottoNumber);
    }

    private void isLottoNumber(String it) {
        if (Integer.valueOf(it) <= 0 || Integer.valueOf(it) > 45) {
            throw new RuntimeException("로또 숫자는 1~45 숫자만 허용합니다.");
        }
    }

    private void shouldNumber(List<String> parts) {
        parts.forEach(Integer::parseInt);
    }
}
