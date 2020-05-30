package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicketGenerator {

    private final static int LOTTO_MAX_NUMBER = 45;
    private final static int LOTTO_MIN_NUMBER = 1;
    private final static int LOTTO_TICKET_SIZE = 6;

    private static List<LottoNumber> lottoNumbers = IntStream.rangeClosed(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER)
            .mapToObj(LottoNumber::create)
            .collect(Collectors.toList());

    protected static List<LottoNumber> makeLottoTicket() {
        Collections.shuffle(lottoNumbers);

        List<LottoNumber> newLottoNumbers = new ArrayList<>();
        for (int i = 0; i < LOTTO_TICKET_SIZE; i++) {
            newLottoNumbers.add(lottoNumbers.get(i));
        }

        Collections.sort(newLottoNumbers);
        return newLottoNumbers;
    }
}
