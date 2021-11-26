package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.exception.NotNumberException;

public class WinnerLottoTicket extends AbstractLottoTicket {

    private static final String DELIMITER = ", ";

    private WinnerLottoTicket(List<Integer> lottoNumber) {
        super(lottoNumber);
    }

    public static WinnerLottoTicket from(String input) {
        return new WinnerLottoTicket(mapToInt(input.split(DELIMITER)));
    }

    public List<Long> findWinningCount(LottoTickets lottoTickets) {
        return lottoTickets.getLottoTickets().stream()
            .mapToLong(this::findWinningCount)
            .boxed()
            .collect(Collectors.toCollection(ArrayList::new));
    }

    private long findWinningCount(LottoTicket lottoTicket) {
        return lottoTicket.getLottoTicket()
            .stream()
            .filter(number -> this.lottoTicket.contains(number))
            .count();
    }

    private static List<Integer> mapToInt(String[] input) {
        try {
            return Arrays.stream(input)
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));
        } catch (NumberFormatException e) {
            throw new NotNumberException();
        }
    }

}
