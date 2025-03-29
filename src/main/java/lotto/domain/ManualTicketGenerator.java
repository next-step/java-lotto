package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ManualTicketGenerator {
    public static LottoTicket generate(int[] numbers) {
        List<LottoNumber> lottoNumbers = Arrays.stream(numbers)
                .mapToObj(LottoNumber::of)
                .collect(Collectors.toList());
        return new LottoTicket(lottoNumbers);
    }
}
