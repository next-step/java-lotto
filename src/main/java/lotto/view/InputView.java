package lotto.view;

import lotto.domain.LottoNumbers;
import lotto.domain.LottoTicket;
import lotto.domain.LottoWiningNumbers;
import lotto.function.SixLottoNumbers;
import lotto.model.LottoRequestVO;

import java.util.Scanner;

public class InputView {
  private static final String FIRST_ASK_A_QUESTION = "구입금액을 입력해 주세요.";
  private static final String ISSUED_LOTTO_TICKET_FORMAT = "%d개를 구매했습니다.";
  private static final String WINNER_LOTTO_NUMBER_ASK = "지난 주 당첨 번호를 입력해 주세요.";

  public static LottoRequestVO buyLotto() {
    try (Scanner scanner = new Scanner(System.in)) {
      System.out.println(FIRST_ASK_A_QUESTION);
      String money = scanner.nextLine();
      LottoTicket lottoTicket = LottoTicket.toBuy(Integer.parseInt(money), new SixLottoNumbers());
      printBoughtLottoNumber(lottoTicket);

      System.out.println("\n" + WINNER_LOTTO_NUMBER_ASK);
      String lottoWiningNumbersString = scanner.nextLine();
      LottoWiningNumbers lottoWiningNumbers = LottoWiningNumbers.generate(lottoWiningNumbersString);
      return new LottoRequestVO(lottoTicket, lottoWiningNumbers);
    }
  }

  private static void printBoughtLottoNumber(LottoTicket lottoTicket) {
    System.out.println(String.format(ISSUED_LOTTO_TICKET_FORMAT, lottoTicket.ticketCount()));
    for (LottoNumbers lottoNumbers : lottoTicket.getLottoNumbers()) {
      System.out.println(lottoNumbers);
    }
  }
}
