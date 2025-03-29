package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class ManualTicketGenerator {
    public static LottoTicket generate(List<Integer> numbers) {
        List<LottoNumber> lottoNumbers = numbers.stream()
                .map(LottoNumber::of)
                .collect(Collectors.toList());
        return new LottoTicket(lottoNumbers);
    }
}
