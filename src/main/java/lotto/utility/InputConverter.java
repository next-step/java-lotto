package lotto.utility;

import lotto.domain.Lotto;
import lotto.exception.BudgetException;
import lotto.exception.LottoException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputConverter {

  public static int convertBudgetToInt(String strNumber) {

    BudgetException.checkIntType(strNumber);

    int budget = Integer.parseInt(strNumber);

    BudgetException.checkScale(budget);

    return budget;
  }

  public static List<Integer> convertNumberToList(String targetNumber) {
    List<Integer> numberList = Arrays.stream(targetNumber.split(", "))
        .map(InputConverter::convertNumber)
        .collect(Collectors.toList());

    LottoException.checkSize(numberList);

    return numberList;
  }

  public static int convertNumber(String strNumber) {
    LottoException.convertNumber(strNumber);

    return Integer.parseInt(strNumber);
  }
}
