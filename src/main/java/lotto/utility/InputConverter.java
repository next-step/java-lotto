package lotto.utility;

import lotto.validation.BudgetValidation;
import lotto.validation.LottoValidation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputConverter {

  public static int convertBudgetToInt(String strNumber) {

    BudgetValidation.checkIntType(strNumber);

    int budget = Integer.parseInt(strNumber);

    BudgetValidation.checkScale(budget);

    return budget;
  }

  public static List<Integer> convertNumberToList(String targetNumber) {
    List<Integer> numberList = Arrays.stream(targetNumber.split(", "))
        .map(InputConverter::convertLottoNumber)
        .collect(Collectors.toList());

    LottoValidation.checkSize(numberList);
    LottoValidation.checkDuplicate(numberList);

    return numberList;
  }

  public static int convertLottoNumber(String strNumber) {
    LottoValidation.checkLottoType(strNumber);

    return Integer.parseInt(strNumber);
  }

  public static int convertBonusNumber(List<Integer> targetNumber, String strNumber) {
    int bonusNumber = convertLottoNumber(strNumber);

    LottoValidation.checkDuplicateBonus(targetNumber, bonusNumber);

    return bonusNumber;
  }
}
