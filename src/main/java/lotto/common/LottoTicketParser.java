package lotto.common;

import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;

import java.util.Arrays;
import java.util.stream.Collectors;

public class LottoTicketParser {

    private static final String DEFAULT_SEPARATOR = ",";

    public LottoTicket parse(String elements) {
        return new LottoTicket(
                Arrays.stream(elements.split(DEFAULT_SEPARATOR))
                .map(String::trim)
                .map(Integer::parseInt)
                .map(LottoNumber::new)
                .collect(Collectors.toList())
        );
    }
}
