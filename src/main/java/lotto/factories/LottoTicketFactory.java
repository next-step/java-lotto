package lotto.factories;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoTicket;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicketFactory {
    private static final List<LottoNumber> allLottoNumbers =
            IntStream.rangeClosed(LottoNumber.MIN_LOTTO_NUMBER, LottoNumber.MAX_LOTTO_NUMBER)
                    .mapToObj(LottoNumber::of).collect(Collectors.toList());

    public static LottoTicket createAutoLottoTicket() {
        Collections.shuffle(allLottoNumbers);

        final LottoNumbers lottoNumbers = new LottoNumbers(
                allLottoNumbers.stream()
                        .limit(LottoNumbers.LOTTO_NUMBERS_SIZE)
                        .sorted()
                        .collect(Collectors.toList())
        );
        final LottoNumber bonusNumber = allLottoNumbers.stream()
                .filter(e -> !lottoNumbers.contains(e))
                .findFirst()
                .orElseThrow(RuntimeException::new);

        return new LottoTicket(lottoNumbers, bonusNumber);
    }

    public static LottoTicket from(String[] lottoNumbers, String bonusNumber) {
        return new LottoTicket(
                new LottoNumbers(
                        Arrays.stream(lottoNumbers)
                                .map(String::trim)
                                .mapToInt(Integer::parseInt)
                                .mapToObj(LottoNumber::of)
                                .collect(Collectors.toList())
                ),
                LottoNumber.of(Integer.parseInt(bonusNumber))
        );
    }
}
