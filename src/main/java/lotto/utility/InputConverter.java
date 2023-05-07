package lotto.utility;

import lotto.domain.Lotto;
import lotto.exception.BudgetException;
import lotto.exception.LottoException;

import java.util.ArrayList;
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
        .map(InputConverter::convertLottoNumber)
        .collect(Collectors.toList());

    LottoException.checkSize(numberList);
    LottoException.checkDuplicate(numberList);

    return numberList;
  }

  public static int convertLottoNumber(String strNumber) {
    LottoException.checkLottoType(strNumber);

    return Integer.parseInt(strNumber);
  }

  public static int convertBonusNumber(List<Integer> targetNumber, String strNumber) {
    int bonusNumber = convertLottoNumber(strNumber);

    LottoException.checkDuplicateBonus(targetNumber, bonusNumber);

    return bonusNumber;
  }
}
