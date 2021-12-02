package lotto.view;

import lotto.domain.entity.Budget;
import lotto.domain.entity.LottoNumber;
import lotto.domain.entity.LottoTicket;
import lotto.domain.entity.LottoTickets;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class InputView {

  private static final String BUDGET_INPUT_MESSAGE = "구매 금액을 입력해 주세요.";
  private static final String WINNING_INPUT_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
  private static final String BONUS_INPUT_MESSAGE = "보너스 볼을 입력해 주세요.";
  private static final String MANUAL_COUNT_INPUT_MESSAGE = "수동으로 구매할 로또 수를 입해 주세요.";
  private static final String MANUAL_INPUT_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";

  private static final String WRONG_INPUT_MANUAL_NUMBER ="구매 숫자를 잘못 입력하셨습니다.";

  private static final String COMMA =",";

  private static final InputView instance = new InputView();
  private static final Scanner scanner = new Scanner(System.in);

  private InputView() {
  }

  public static InputView getInstance() {
    return InputView.instance;
  }

  public Budget inputBudget() {
    System.out.println(BUDGET_INPUT_MESSAGE);
    return new Budget(Integer.parseInt(scanner.next()));
  }

  public LottoTicket inputWinning() {
    System.out.println(WINNING_INPUT_MESSAGE);
    return inputTickets();
  }

  public LottoNumber inputBonus() {
    System.out.println(BONUS_INPUT_MESSAGE);
    int number = Integer.parseInt(scanner.next());

    return new LottoNumber(number);
  }

  private LottoTicket inputTickets() {
    List<LottoNumber> splitNumbersByDelimiter = getSplitNumbersByDelimiter(scanner.nextLine());
    return new LottoTicket(splitNumbersByDelimiter);
  }

  private List<LottoNumber> getSplitNumbersByDelimiter(String numbrerList) {
    return Arrays.stream(numbrerList.split(COMMA))
                 .map(string -> new LottoNumber(Integer.parseInt(string.trim())))
                 .collect(toList());
  }

  private int inputManualTicketsCount() {
    System.out.println(MANUAL_COUNT_INPUT_MESSAGE);
    int count = Integer.parseInt(scanner.next());

    if (count < 0) {
      throw new IllegalArgumentException(WRONG_INPUT_MANUAL_NUMBER);
    }

    return count;
  }

  public LottoTickets inputManualTickets() {
    int count = inputManualTicketsCount();
    scanner.nextLine();
    System.out.println(MANUAL_INPUT_MESSAGE);
    return IntStream.range(0, count)
                    .mapToObj(i -> inputTickets())
                    .collect(collectingAndThen(toList(), LottoTickets::new));
  }
}
