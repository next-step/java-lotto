package view;

import domain.LottoFormatter;
import domain.LottoNumber;
import java.util.Set;
import java.util.stream.Collectors;

public class DefaultLottoFormatter implements LottoFormatter {

    public static final String JOIN_DELIMITER = ", ";
    public static final String JOIN_PREFIX = "[";
    public static final String JOIN_SUFFIX = "]";

    @Override
    public String format(final Set<LottoNumber> lottoNumbers) {
        return lottoNumbers.stream()
            .map(LottoNumber::getValue)
            .sorted()
            .map(String::valueOf)
            .collect(Collectors.joining(JOIN_DELIMITER, JOIN_PREFIX, JOIN_SUFFIX));
    }
}
