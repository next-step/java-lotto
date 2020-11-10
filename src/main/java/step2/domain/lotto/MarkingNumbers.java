package step2.domain.lotto;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class MarkingNumbers {

    public static final String DELIMITER = ", ";
    public static final String STRING_FORM = "[%s]";
    private final Set<LottoNumber> markingNumbers;

    public MarkingNumbers(Set<LottoNumber> markingNumbers) {
        this.markingNumbers = markingNumbers;
    }

    @Override
    public String toString() {
        String join = String.join(DELIMITER, flat());
        return String.format(STRING_FORM, join);
    }

    private List<String> flat() {
        return markingNumbers.stream()
                .map(LottoNumber::getString)
                .collect(Collectors.toList());
    }

    public boolean contains(Integer number) {
        return this.contains(new LottoNumber(number));
    }

    public boolean contains(LottoNumber lottoNumber) {
        return markingNumbers.contains(lottoNumber);
    }
}
