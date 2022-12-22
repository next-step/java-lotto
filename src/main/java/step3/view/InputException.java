package step3.view;

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
        if (input.matches("[a-zA-Z]+")) {
            return 1;
        }
        return 0;
    }


    public static boolean isInputBonusPossible(String input) {
        if (isAlpha(input) != 0) {
            System.out.println("숫자값만 입력해주세요.");
            return false;
        }

        if (numberRange(input) != 0) {
            System.out.println("1~46 범위 값만 입력해주세요.");
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
}
