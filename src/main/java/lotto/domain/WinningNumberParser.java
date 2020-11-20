package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumberParser {
    public static final String DELIMITER = ",";

    public List<Integer> parse(String expression) {
        if (StringUtils.isNullOrBlank(expression)) throw new LottoNumberParseException("로또번호에 빈값이 입력되어습니다");
        List<String> parts = Arrays.asList(expression.split(DELIMITER)).stream()
                .map(it -> it.trim())
                .collect(Collectors.toList());

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
            throw new LottoNumberParseException("로또번호는 1~45 사이 숫자만 허용합니다.");
        }
    }

    private void shouldNumber(List<String> parts) {
        try {
            parts.forEach(Integer::parseInt);
        } catch ( NumberFormatException e ){
            throw new LottoNumberParseException("로또번호는 숫자만 허용합니다.", e);
        }
    }
}
