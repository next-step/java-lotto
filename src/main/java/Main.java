import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import lotto.LottoEvent;
import lotto.LottoTicketNumber;
import lotto.LottoTicketNumberSet;
import lotto.User;
import view.PrintResult;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("구입금액을 입력해 주세요.");
    int amount = scanner.nextInt();

    LottoEvent lottoEvent = new LottoEvent();
    User user = new User(amount, lottoEvent);

    user.buyAllLottoTickets();
    System.out.printf("%d개를 구매했습니다.%n", user.getLottoTickets().size());

    System.out.printf(PrintResult.printUserLottoTickets(user));

    System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
    List<Integer> winningNumbers = List.of(scanner.next().split(","))
        .stream()
        .map(Integer::parseInt)
        .collect(Collectors.toList());

    lottoEvent.setWinningLottoTicketNumberSet(new LottoTicketNumberSet(
        winningNumbers.stream()
            .map(LottoTicketNumber::new)
            .collect(Collectors.toList())
    ));

    System.out.println(PrintResult.printUserProfit(user));
  }
}
