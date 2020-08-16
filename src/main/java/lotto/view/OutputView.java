package lotto.view;

import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String LOTTO_BUY_COUNT_MESSAGE = "개를 구매했습니다.";

    private OutputView() {
    }

    public static void printLottoTickets(LottoTickets lottoTickets) {
        System.out.println(lottoTickets.number() + LOTTO_BUY_COUNT_MESSAGE);

        List<String> lottoNumbers = getLottoNumberResult(lottoTickets);
        lottoNumbers.forEach(System.out::println);
    }

    private static List<String> getLottoNumberResult(LottoTickets lottoTickets) {
        return lottoTickets.stream()
                .map(LottoTicket::stream)
                .map(OutputView::getLottoNumbersByTicket)
                .map(numbers -> "[" + numbers + "]")
                .collect(Collectors.toList());
    }

    private static String getLottoNumbersByTicket(List<LottoNumber> lottoNumbers) {
        return lottoNumbers.stream()
                .map(LottoNumber::valueOf)
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }
}
