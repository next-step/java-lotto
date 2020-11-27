package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbersParser {
    public static final String DELIMITER = ",";

    public List<LottoNumber> parse(String expression) {
        if (StringUtils.isNullOrBlank(expression)) throw new LottoNumberParseException("로또번호에 빈값이 입력되어습니다");
        List<String> parts = Arrays.asList(expression.split(DELIMITER)).stream()
                .map(it -> it.trim())
                .collect(Collectors.toList());

        shouldNumber(parts);

        return parts.stream()
                .map(it -> new LottoNumber(Integer.valueOf(it)))
                .collect(Collectors.toList());
    }

    private void shouldNumber(List<String> parts) {
        try {
            parts.forEach(Integer::parseInt);
        } catch ( NumberFormatException e ){
            throw new LottoNumberParseException("로또번호는 숫자만 허용합니다.", e);
        }
    }
}
