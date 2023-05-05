package lotto.utility;

import lotto.domain.Lotto;
import lotto.exception.BudgetException;
import lotto.exception.LottoException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputConverter {

  public static int convertBudgetToNumberOfPurchase(String strNumber) {
    int budget = BudgetException.convertBudget(strNumber);

    BudgetException.checkScale(budget);

    return budget / Lotto.PRICE;
  }

  public static List<Integer> convertNumberToList(String targetNumber) {
    List<Integer> numberList = Arrays.stream(targetNumber.split(", "))
        .map(LottoException::convertNumber)
        .collect(Collectors.toList());

    LottoException.checkSize(numberList);

    return numberList;
  }
}
