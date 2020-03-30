package lotto.model;

import lotto.model.wrapper.LottoNumber;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class WinningLottoTicket extends LottoTicket {

    private WinningLottoTicket(final Set<LottoNumber> numbers) {
        super(numbers);
    }

    public static WinningLottoTicket newInstance(final Set<LottoNumber> numbers) {
        return new WinningLottoTicket(numbers);
    }

    public static WinningLottoTicket create(LottoNumber ...numbers) {
        Set<LottoNumber> lottoNumbers = Arrays.stream(numbers)
                .collect(Collectors.toSet());
        return new WinningLottoTicket(lottoNumbers);
    }
}
