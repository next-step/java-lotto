package lotto.view;

import lotto.domain.LottoNumbers;
import lotto.domain.LottoTicket;

import java.util.Scanner;

public final class InputView {
  private static final String FIRST_ASK_A_QUESTION = "구입금액을 입력해 주세요.";
  private static final String ISSUED_LOTTO_TICKET_FORMAT = "%d개를 구매했습니다.";
  private static final String WINNER_LOTTO_NUMBER_ASK = "지난 주 당첨 번호를 입력해 주세요.";

  private InputView() {
  }

  public static int buyLotto() {
    Scanner scanner = new Scanner(System.in);
    System.out.println(FIRST_ASK_A_QUESTION);
    return scanner.nextInt();
  }

  public static void printBoughtLottoNumbers(LottoTicket lottoTicket) {
    System.out.println(String.format(ISSUED_LOTTO_TICKET_FORMAT, lottoTicket.ticketCount()));
    for (LottoNumbers lottoNumbers : lottoTicket.getList()) {
      System.out.println(lottoNumbers);
    }
  }

  public static String writeLottoWiningNumbersString() {
    try (Scanner scanner = new Scanner(System.in)) {
      System.out.println("\n" + WINNER_LOTTO_NUMBER_ASK);
      return scanner.nextLine();
    }
  }
}
