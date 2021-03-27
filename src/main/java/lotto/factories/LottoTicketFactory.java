package lotto.factories;

import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTicketFactory {
    public static LottoTicket createAutoLottoTicket() {
        final List<LottoNumber> allLottoNumbers = LottoNumber.allLottoNumbers();
        Collections.shuffle(allLottoNumbers);

        final List<LottoNumber> lottoNumbers =
                allLottoNumbers.stream()
                        .limit(LottoTicket.LOTTO_NUMBERS_SIZE)
                        .sorted()
                        .collect(Collectors.toList());

        return new LottoTicket(lottoNumbers);
    }

    public static LottoTicket from(String[] lottoNumbers) {
        return new LottoTicket(
                Arrays.stream(lottoNumbers)
                        .map(String::trim)
                        .mapToInt(Integer::parseInt)
                        .mapToObj(LottoNumber::of)
                        .collect(Collectors.toList())
        );
    }
}
