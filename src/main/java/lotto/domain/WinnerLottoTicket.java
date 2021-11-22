package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinnerLottoTicket extends AbstractLottoTicket {

    private static final String DELIMITER = ", ";

    private WinnerLottoTicket(List<Integer> lottoNumber) {
        super(lottoNumber);
    }

    public static WinnerLottoTicket from(String input) {
        return new WinnerLottoTicket(MapToInt(input.split(DELIMITER)));
    }

    public List<Long> winnerCount(LottoTickets lottoTickets) {
        return lottoTickets.getLottoTickets().stream()
            .mapToLong(this::winnerCount)
            .boxed()
            .collect(Collectors.toCollection(ArrayList::new));
    }

    private long winnerCount(LottoTicket lottoTicket) {
        return lottoTicket.getLottoTicket()
            .stream()
            .filter(number -> this.lottoTicket.contains(number))
            .count();
    }

    private static List<Integer> MapToInt(String[] input) {
        try {
            return Arrays.stream(input)
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));
        } catch (NumberFormatException e) {
            throw new NumberFormatException("숫자만 입력할 수 있습니다.");
        }
    }

}
