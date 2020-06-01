package step2.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoData {

    public static List<LottoTicket> createLottoTickets(int count) {
        return IntStream.rangeClosed(1, count)
                .mapToObj(i -> createLottoNumbers(6))
                .map(LottoTicket::create)
                .collect(Collectors.toList());
    }

    public static List<LottoNumber> createLottoNumbers(int count) {
        return IntStream.rangeClosed(1, count)
                .mapToObj(LottoNumber::valueOf)
                .collect(Collectors.toList());
    }
}
