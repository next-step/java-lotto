package lotto.lottoView;

import com.sun.tools.internal.xjc.reader.xmlschema.parser.IncorrectNamespaceURIChecker;
import lotto.LottoNo;
import lotto.exception.IncorrectNumberBoundryException;

import java.util.InputMismatchException;
import java.util.Scanner;


public class InputView {

    private static final int MAX_NUMBER = 45;
    private static final int STANDARD_NUMBER = 1000;
    private static Scanner sc = new Scanner(System.in);

    public static int inputInitCost() {
        System.out.println("구입금액을 입력해 주세요.");
        int cost = sc.nextInt();

        while (cost % STANDARD_NUMBER != 0 || cost == 0) {
            System.out.println("정확한 금액을 입력해 주세요.(1,000원 단위)");
            cost = sc.nextInt();
        }
        return cost;
    }

    public static String inputWinNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return (sc.nextLine());
    }

    public static int inputBonusNumber() {
        int bonusBall = 0;
        System.out.println("보너스 볼을 입력해 주세요.");
        try {
            bonusBall = sc.nextInt();

            if (bonusBall < 0 || bonusBall > MAX_NUMBER) {
                throw new IncorrectNumberBoundryException("범위가 잘못 되었습니다.");
            }
        } catch (IncorrectNumberBoundryException inb) {
            System.out.println(inb.getMessage());
            System.out.println("정확한 범위의 값을 입력해주세요.(0~" + MAX_NUMBER + ")");
            bonusBall = sc.nextInt();
        } catch (Exception e) {
            System.out.println("에러가 발생하였습니다. " + e.getStackTrace());
        }
        return bonusBall;
    }

    public static int inputManualCount(int totalCount) {
        int manualCount = 0;
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");

        try {
            manualCount = sc.nextInt();
            sc.nextLine();
            if (manualCount < 0 || manualCount > totalCount) {
                throw new IncorrectNumberBoundryException("범위가 잘못 되었습니다.");
            }
        } catch (InputMismatchException ime) {
            System.out.println("정확한 숫자 포맷으로 입력해주세요.");
            manualCount = sc.nextInt();
            sc.nextLine(); //개행버퍼 지움
        } catch (IncorrectNumberBoundryException inb) {
            System.out.println(inb.getMessage());
            System.out.println("정확한 범위의 값을 입력해주세요.(0~" + totalCount + ")");
            manualCount = sc.nextInt();
            sc.nextLine(); //개행버퍼 지움
        }
        return manualCount;
    }

    public static String[] inputManualNumbers(int manualCount) {
        String[] manualNumbers = new String[manualCount];
        if (manualCount > 0) {
            System.out.println("수동으로 구매할 번호를 입력해 주세요.");
            for (int i = 0; i < manualCount; i++) {
                manualNumbers[i] = sc.nextLine();
            }
        }
        return manualNumbers;
    }

}
