package lotto.ui;

import java.io.PrintStream;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.LottoTicket;

public class ResultView {

  private static final String PURCHASED_LOTTO_COUNT = "개를 구매했습니다.";
  private static final PrintStream printStream = System.out;

  public static void printLottoCount(int lottoCount) {
    printStream.println(lottoCount + PURCHASED_LOTTO_COUNT);
  }

  public static void printLottoTickets(List<LottoTicket> lottoTickets) {
    lottoTickets.stream().map(lottoTicket -> lottoTicket.getLottoNumbers()
            .stream()
            .map(String::valueOf)
            .collect(Collectors.joining(", ", "[", "]")))
        .forEach(printStream::println);
  }
}
