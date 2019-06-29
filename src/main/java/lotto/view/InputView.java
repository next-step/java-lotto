package lotto.view;

import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class InputView {

  public static int inputPrice(Scanner scanner) {
    System.out.println("구입금액을 입력해주세요.");
    return Integer.valueOf(
        validateInput(scanner.nextLine()));
  }

  private static String validateInput(String input) {
    if (input.isEmpty()) {
      throw new IllegalArgumentException("잘못된 입력입니다.");
    }
    return input;
  }

  public static List<Integer> winNumbers(Scanner scanner) {
    System.out.println("지난 주 당첨 번호를 입력해 주세요.");

    return splitInput(scanner);
  }

  private static List<Integer> splitInput(Scanner scanner) {
    return Stream.of(scanner.nextLine().split(","))
        .map(String::trim)
        .mapToInt(Integer::valueOf)
        .boxed()
        .collect(toList());
  }

  public static int bonusNumber(Scanner scanner) {
    System.out.println("보너스 볼을 입력해 주세요.");
    return Integer.valueOf(scanner.nextLine());
  }

  public static int manualBuyLotto(Scanner scanner) {
    System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
    return Integer.valueOf(validateInput(scanner.nextLine()));
  }

  public static LottoTickets getLottoTickets(Scanner scanner, int buyCount) {
    System.out.println("수동으로 구매할 번호를 입력해 주세요");
    List<LottoTicket> lottoTickets = new ArrayList<>();
    for (int i = 0; i < buyCount; i++) {
      lottoTickets.add(new LottoTicket(new LottoNumber(splitInput(scanner))));
    }
    return new LottoTickets(buyCount, lottoTickets);
  }
}