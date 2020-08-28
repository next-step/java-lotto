package lotto.common;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;

public class LottoTicketMachine {
    // 유틸리티 성격을 가진 클래스이므로 묵시적인 생성자를 방지한다.
    private LottoTicketMachine() {
    }

    public static List<LottoTicket> issueTickets(int ticketCount) {
        return Stream.generate(() -> issueTicket())
              .limit(ticketCount)
              .collect(Collectors.toList());
    }

    public static LottoTicket issueTicket(String lottoNumberParam) {
        Set<LottoNumber> lottoNumbers = convertToLottoNumbers(lottoNumberParam);
        return new LottoTicket(lottoNumbers);
    }

    private static Set<LottoNumber> convertToLottoNumbers(String lottoNumbers) {
        return Arrays.stream(lottoNumbers.split(","))
              .map(numberValue -> new LottoNumber(numberValue.trim()))
              .collect(Collectors.toSet());
    }

    private static LottoTicket issueTicket() {
        Set<LottoNumber> sixNumbers = LottoShuffleMachine.getSixNumbers();
        return new LottoTicket(sixNumbers);
    }
}
