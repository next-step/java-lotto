package lottoGame.view;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class InputException {
    public static boolean isInputMoneyPossible(String input) {
        if (isAlpha(input) == 1) {
            System.out.println("숫자값만 입력해주세요.");
            return false;
        }
        if (!canBuy(input)) {
            System.out.println("1000원 이상만 입력해주세요.");
            return false;
        }
        return true;
    }

    private static boolean canBuy(String input) {
        return Integer.parseInt(input) >= 1000;
    }

    private static int isAlpha(String input) {
        if (input.isEmpty() || input.matches("[a-zA-Z]+")) {
            return 1;
        }
        return 0;
    }


    public static boolean isInputBonusPossible(List<Integer> winningLotto, String bonusNumber) {
        if (isAlpha(bonusNumber) != 0) {
            System.out.println("숫자값만 입력해주세요.");
            return false;
        }
        if (numberRange(bonusNumber) != 0) {
            System.out.println("1~46 범위 값만 입력해주세요.");
            return false;
        }
        if (winningLotto.contains(Integer.parseInt(bonusNumber))){
            System.out.println("당첨 로또와 중복되지 않는 숫자를 입력해세요");
            return false;
        }
        return true;
    }

    public static boolean isInputLottoRangePossible(String[] input) {
        int errResult = checkArrNumberRange(input);
        if (errResult != 0) {
            System.out.println("1 ~ 45 범위 숫자만 입력해주세요.");
            return false;
        }
        return true;
    }

    private static int checkArrNumberRange(String[] input) {
        int errNum = 0;
        for (String str : input) {
            errNum += numberRange(str);
        }
        return errNum;
    }

    public static int numberRange(String number) {
        int inputNumber = Integer.parseInt(number);
        if (inputNumber <= 0 || inputNumber >= 46) {
            return 1;
        }
        return 0;
    }

    public static boolean isInputLottoPossible(String[] strArr) {
        if (new HashSet<>(Arrays.asList(strArr)).size() != 6) {
            System.out.println("6개의 숫자값을 입력해주세요.");
            return false;
        }
        int errResult = checkStrArr(strArr);
        if (errResult != 0) {
            System.out.println("숫자값만 입력해주세요.");
            return false;
        }
        return true;
    }

    private static int checkStrArr(String[] input) {
        int errAlpha = 0;
        for (String str : input) {
            errAlpha += isAlpha(str);
        }
        return errAlpha;
    }

    public static boolean isInputCountPossible(String inputCount) {
        if (isAlpha(inputCount) == 1) {
            System.out.println("숫자값만 입력해주세요.");
            return false;
        }
        return true;
    }
}
