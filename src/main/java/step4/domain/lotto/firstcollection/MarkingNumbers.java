package step4.domain.lotto.firstcollection;

import step4.Constant;
import step4.domain.lotto.LottoTicket;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MarkingNumbers {
    private static final String DELIMITER_WITH_SPACE = ", ";
    private static final String DELIMITER_NO_SPACE = ",";

    public static final String STRING_FORM = "[%s]";
    private static final int MARKING_ANCHOR_POINT = 6;

    private final Set<LottoNumber> markingNumbers;

    public MarkingNumbers(Set<LottoNumber> markingNumbers) {
        this.markingNumbers = markingNumbers;
    }

    public static MarkingNumbers of(String string) {
        return new MarkingNumbers(stringToObj(string));
    }

    private static Set<LottoNumber> stringToObj(String string) {
        Set<LottoNumber> lottoNumbers = Stream.of(string.split(DELIMITER_NO_SPACE))
                .map(LottoNumber::new)
                .collect(Collectors.toSet());
        isValidLottoNumbers(lottoNumbers);
        return lottoNumbers;
    }

    private static void isValidLottoNumbers(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != MARKING_ANCHOR_POINT) {
            throw new IllegalArgumentException(Constant.ERROR_INVALID_MARKING_NUMBER);
        }
    }

    @Override
    public String toString() {
        String join = String.join(DELIMITER_WITH_SPACE, flat());
        return String.format(STRING_FORM, join);
    }

    private List<String> flat() {
        return markingNumbers.stream()
                .map(LottoNumber::getString)
                .collect(Collectors.toList());
    }

    public boolean contains(LottoNumber lottoNumber) {
        return markingNumbers.contains(lottoNumber);
    }

    public int countEquals(LottoTicket ticket) {
        return Math.toIntExact(markingNumbers.stream()
                .filter(ticket::isMarked)
                .count());
    }
}
