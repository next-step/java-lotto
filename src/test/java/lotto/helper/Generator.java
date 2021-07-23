package lotto.helper;

import lotto.number.LottoNumber;
import lotto.number.LottoNumberGenerator;
import lotto.ticker.LottoTicket;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Generator {
    private Generator() {}

    public static List<LottoNumber> lottoNumbersOf(int... numbers) {
        return Arrays.stream(numbers)
                .mapToObj(LottoNumber::from)
                .collect(Collectors.toList());
    }

    public static List<LottoTicket> generateNumberOfLottoTicket(int numberOfLottoTicket) {
        return IntStream.rangeClosed(0, numberOfLottoTicket)
                .mapToObj(x -> LottoTicket.from(LottoNumberGenerator.generate()))
                .collect(Collectors.toList());
    }
}
