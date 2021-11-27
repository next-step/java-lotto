package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.exception.NotNumberException;

public class WinnerLottoTicket extends AbstractLottoTicket {

    private static final String DELIMITER = ", ";

    private final LottoNumber bonusNumber;

    private WinnerLottoTicket(List<Integer> lottoNumber, LottoNumber bonusNumber) {
        super(lottoNumber);
        this.bonusNumber = bonusNumber;
    }

    public static WinnerLottoTicket of(String winnerNumber, int bonusNumber) {
        List<Integer> winnerNumbers = mapToInt(winnerNumber.split(DELIMITER));

        validBonusNumber(winnerNumbers, bonusNumber);
        return new WinnerLottoTicket(winnerNumbers, LottoNumber.from(bonusNumber));
    }

    public List<Long> findLottoMatchCount(LottoTickets lottoTickets) {
        return lottoTickets.getLottoTickets().stream()
            .mapToLong(this::findLottoMatchCount)
            .boxed()
            .collect(Collectors.toCollection(ArrayList::new));
    }

    public long findLottoMatchCount(LottoTicket lottoTicket) {
        return lottoTicket.getLottoTicket()
            .stream()
            .filter(number -> this.lottoTicket.contains(number))
            .count();
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
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

    private static void validBonusNumber(List<Integer> winnerNumbers, int bonusNumber) {
        if (winnerNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 달라야 합니다.");
        }
    }

}
