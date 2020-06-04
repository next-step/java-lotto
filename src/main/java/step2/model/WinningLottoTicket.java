package step2.model;

import java.util.List;
import java.util.stream.Collectors;

public class WinningLottoTicket extends LottoTicket {

    public WinningLottoTicket(List<LottoNumber> numbers) {
        super(numbers);
    }

    public static WinningLottoTicket createBy(List<Integer> numbers) {
        return new WinningLottoTicket(numbers.stream()
            .map(LottoNumber::of)
            .collect(Collectors.toList()));
    }
}
