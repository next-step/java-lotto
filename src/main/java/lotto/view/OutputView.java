package lotto.view;

import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;

import java.util.Arrays;
import java.util.List;

public class OutputView {

    public static void printLottoTickets(List<LottoTicket> lottoTickets) {
        System.out.println(lottoTickets.size() + "개를 구매했습니다.");
        lottoTickets.forEach(lottoTicket -> System.out.println(lottoNumbersToString(lottoTicket.getLottoNumbers())));
    }
    
    private static String lottoNumbersToString(List<LottoNumber> lottoNumbers) {
        return Arrays.toString(lottoNumbers.stream()
                .mapToInt(LottoNumber::getValue)
                .toArray());
    }
}
