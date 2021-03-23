package lotto.factories;

import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicketFactory {
    private static final List<LottoNumber> allLottoNumbers =
            IntStream.rangeClosed(LottoNumber.MIN_LOTTO_NUMBER, LottoNumber.MAX_LOTTO_NUMBER)
                    .mapToObj(LottoNumber::new).collect(Collectors.toList());

    public static LottoTicket createAutoLottoTicket() {
        Collections.shuffle(allLottoNumbers);

        return new LottoTicket(
                allLottoNumbers.stream()
                        .limit(LottoTicket.LOTTO_NUMBERS_SIZE)
                        .collect(Collectors.toList())
        );
    }
}
