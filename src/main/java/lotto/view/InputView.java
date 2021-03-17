package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

import java.util.*;
import java.util.stream.Collectors;

public class InputView {

  private static final String INPUT_PURCHASE_PRICE = "구매 금액을 입력해주세요.";
  private static final String INPUT_WINNING_LOTTO_NUMBERS = "지난 주 당첨 번호를 입력해 주세요";
  private static final String DELIMITER = ",";

  public int inputPurchasePrice() {
    System.out.println(INPUT_PURCHASE_PRICE);
    return new Scanner(System.in).nextInt();
  }

  public List<Integer> inputWinningLottoNumbers() {

    System.out.println(INPUT_WINNING_LOTTO_NUMBERS);
    String winngLottoNumbers = new Scanner(System.in).nextLine();

    return Arrays.stream(winngLottoNumbers.split(DELIMITER))
        .map(Integer::valueOf)
        .collect(Collectors.toList());
  }
}
