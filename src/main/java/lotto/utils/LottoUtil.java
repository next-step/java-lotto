package lotto.utils;

import lotto.model.LottoTicket;
import lotto.model.wrapper.LottoNumber;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoUtil {
    private static final String COMMA_DELIMITER = ",";

    private LottoUtil() {
    }

    private static String[] separateLineWithComma(final String line) {
        return line.split(COMMA_DELIMITER);
    }

    public static Set<LottoNumber> convertTo(final String line) {
        String[] separateLine = separateLineWithComma(line);
        return Arrays.stream(separateLine)
                .map(LottoNumber::of)
                .collect(Collectors.toSet());
    }

    public static List<LottoTicket> convertTo(final List<String> lines) {
        return lines.stream()
                .map(line -> LottoTicket.newInstance(convertTo(line)))
                .collect(Collectors.toList());
    }
}
