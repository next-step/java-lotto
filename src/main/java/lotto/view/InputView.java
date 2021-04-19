package lotto.view;

import lotto.domain.LottoNumbers;
import lotto.domain.LottoTicket;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class InputView {
  private static final String PLEASE_ENTER_THE_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
  private static final String HOW_MANY_MANUAL_LOTTO_GOING_TO_BUY = "수동으로 구매할 로또 수를 입력해 주세요.";
  private static final String PLEASE_ENTER_THE_MANUAL_LOTTO_NUMBERS = "수동으로 구매할 번호를 입력해 주세요.";
  private static final String ISSUED_LOTTO_TICKET_FORMAT = "수동으로 %d장, 자동으로 %d개를 구매했습니다.";
  private static final String PLEASE_ENTER_THE_WINNER_LOTTO_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
  private static final String PLEASE_ENTER_THE_BONUS_BALL = "보너스 볼을 입력해 주세요.";

  private InputView() {
  }

  public static int getMoneyOfBoughtLotto() {
    Scanner scanner = new Scanner(System.in);
    System.out.println(PLEASE_ENTER_THE_PURCHASE_AMOUNT);
    return scanner.nextInt();
  }

  public static int getCountOfManualLotto() {
    Scanner scanner = new Scanner(System.in);
    System.out.println(HOW_MANY_MANUAL_LOTTO_GOING_TO_BUY);
    return scanner.nextInt();
  }

  public static List<String> getManualLottoNumberStringList(int countOfManualLotto) {
    System.out.println(PLEASE_ENTER_THE_MANUAL_LOTTO_NUMBERS);
    Scanner scanner = new Scanner(System.in);
    return IntStream.range(0, countOfManualLotto)
            .mapToObj(i -> scanner.nextLine())
            .collect(Collectors.toList());
  }

  public static void printBoughtLottoNumbers(LottoTicket lottoTicket) {
    int totalCount = lottoTicket.ticketCount();
    int totalCountOfManual = lottoTicket.ticketManualCount();
    int totalCountOfAuto = totalCount - totalCountOfManual;
    System.out.println(String.format(ISSUED_LOTTO_TICKET_FORMAT, totalCountOfManual, totalCountOfAuto));
    for (LottoNumbers lottoNumbers : lottoTicket.getValues()) {
      System.out.println(lottoNumbers);
    }
  }

  public static String getLottoWiningNumbersString() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("\n" + PLEASE_ENTER_THE_WINNER_LOTTO_NUMBER);
    return scanner.nextLine();
  }

  public static int getBonusBall() {
    Scanner scanner = new Scanner(System.in);
    System.out.println(PLEASE_ENTER_THE_BONUS_BALL);
    return scanner.nextInt();
  }
}
