package lotto.view;

import lotto.domain.entity.Budget;
import lotto.domain.entity.LottoNumber;
import lotto.domain.entity.LottoTicket;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.util.stream.Collectors.toList;

public class InputView {

  private static final String BUDGET_INPUT_MESSAGE = "구매 금액을 입력해 주세요.";
  private static final String WINNING_INPUT_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
  private static final String BONUS_INPUT_MESSAGE = "보너스 볼을 입력해 주세요.";

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
    List<LottoNumber> splitNumbersByDelimiter = getSplitNumbersByDelimiter(scanner.next());

    return new LottoTicket(splitNumbersByDelimiter);
  }

  public LottoNumber inputBonus() {
    System.out.println(BONUS_INPUT_MESSAGE);
    int number = Integer.parseInt(scanner.next());

    return new LottoNumber(number);
  }

  private List<LottoNumber> getSplitNumbersByDelimiter(String numbrerList) {
    return Arrays.stream(numbrerList.split(COMMA))
                 .map(string -> new LottoNumber(Integer.parseInt(string.trim())))
                 .collect(toList());
  }

}
