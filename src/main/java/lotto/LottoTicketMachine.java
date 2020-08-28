package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoTicketMachine {

    public List<LottoTicket> issueTickets(int ticketCount) {
        return Stream.generate(this::issueTicket)
              .limit(ticketCount)
              .collect(Collectors.toList());
    }

    public LottoTicket issueTicket(String lottoNumberParam) {
        Set<LottoNumber> lottoNumbers = convertToLottoNumbers(lottoNumberParam);
        return new LottoTicket(lottoNumbers);
    }

    private Set<LottoNumber> convertToLottoNumbers(String lottoNumbers) {
        return Arrays.stream(lottoNumbers.split(","))
              .map(numberValue -> new LottoNumber(numberValue.trim()))
              .collect(Collectors.toSet());
    }

    private LottoTicket issueTicket() {
        Set<LottoNumber> sixNumbers = LottoShuffleMachine.getSixNumbers();
        return new LottoTicket(sixNumbers);
    }
}
