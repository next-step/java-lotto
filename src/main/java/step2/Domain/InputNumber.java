package step2.Domain;

import step2.util.StringParser;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class InputNumber {

    private static final String DEFAULT_DELIMITER = ",";
    private static final int LOTTO_NUMBERS = 6;
    private final Set<String> numbers;

    public InputNumber(String number) {
        this.numbers = new HashSet<>(Arrays.asList(number.split(DEFAULT_DELIMITER)));
        if (numbers.size() != LOTTO_NUMBERS) {
            throw new IllegalArgumentException("로또 번호는 중복 된 번호를 가질 수 없고 6개 입력해주시기 바랍니다.");
        }
    }

    public List<LottoNumber> numbers() {
        return numbers.stream()
                .map(num -> new LottoNumber(StringParser.parseStringToInt(num.trim())))
                .collect(Collectors.toList());
    }
}
