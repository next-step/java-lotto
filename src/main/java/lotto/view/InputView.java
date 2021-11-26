package lotto.view;

import lotto.domain.entity.Budget;
import lotto.domain.entity.LottoNumber;
import lotto.domain.entity.LottoTicket;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.util.stream.Collectors.toList;

public class InputView {

  private static final String BUDGET_INPUT_MESSAGE = "구매 금액을 입력해 주세요";
  private static final String WINNING_INPUT_MESSAGE = "지난 주 당첨 번호를 입력해 주세요";

  private static final String COMMA =",";

  private static InputView instance;
  private Scanner scanner;

  private InputView() {
  }

  public static InputView getInstance() {
    if (instance == null) {
      instance = new InputView();
      return instance;
    }
    return instance;
  }

  public Budget inputBudget() {
    System.out.println(BUDGET_INPUT_MESSAGE);
    scanner = new Scanner(System.in);

    int cost = scanner.nextInt();

    return new Budget(cost);
  }

  public LottoTicket inputWinning() {
    scanner = new Scanner(System.in);
    System.out.println(WINNING_INPUT_MESSAGE);

    String numberList = scanner.nextLine();
    List<LottoNumber> splitNumbersByDelimiter = getSplitNumbersByDelimiter(numberList);

    return new LottoTicket(splitNumbersByDelimiter);
  }

  private List<LottoNumber> getSplitNumbersByDelimiter(String numbrerList) {
    return Arrays.stream(numbrerList.split(COMMA))
                 .map(string -> new LottoNumber(Integer.parseInt(string.trim())))
                 .collect(toList());
  }

}
