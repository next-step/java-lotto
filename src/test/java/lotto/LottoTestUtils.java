package lotto;

import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;

import java.util.List;
import java.util.stream.Collectors;

public class LottoTestUtils {
    public static LottoTicket createLottoTicket(List<Integer> numbers) {
        return new LottoTicket(
                numbers.stream()
                        .map(LottoNumber::of)
                        .collect(Collectors.toList())
        );
    }
}
