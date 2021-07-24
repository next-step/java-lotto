package lotto.helper;

import lotto.lotto.LottoTicket;
import lotto.lotto.LottoTickets;
import lotto.number.LottoNumber;
import lotto.number.LottoNumberGenerator;
import lotto.number.LottoNumbers;
import lotto.number.WinningNumbers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Generator {
    private Generator() {}

    public static List<LottoNumber> lottoNumberList(int... numbers) {
        return Arrays.stream(numbers)
                .mapToObj(LottoNumber::from)
                .collect(Collectors.toList());
    }

    public static List<LottoTicket> lottoTicketList(int numberOfLottoTicket) {
        return IntStream.rangeClosed(0, numberOfLottoTicket)
                .mapToObj(x -> LottoTicket.from(LottoNumberGenerator.generate()))
                .collect(Collectors.toList());
    }

    public static LottoNumbers lottoNumbers(int... numbers) {
        return LottoNumbers.from(lottoNumberList(numbers));
    }

    public static LottoTicket lottoTicket(int... numbers) {
        return LottoTicket.from(lottoNumbers(numbers));
    }

    public static LottoTickets autoLottoTickets(int size) {
        return IntStream.rangeClosed(0, size)
                .mapToObj(x -> LottoTicket.from(LottoNumberGenerator.generate()))
                .collect(Collectors.collectingAndThen(Collectors.toList(), LottoTickets::from));
    }

    public static WinningNumbers winningNumbers(int bonusNumber, int... numbers) {
        return WinningNumbers.of(lottoNumberList(numbers), LottoNumber.from(bonusNumber));
    }
}
