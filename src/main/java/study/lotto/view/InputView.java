package study.lotto.view;

import study.lotto.model.Lotto;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String LOTTO_NUMBER_DELIMITER = ",";
    private static final String BLANK_STRING = " ";

    private static final Scanner scanner = new Scanner(System.in);

    public static int scanTotalPrice() {
        System.out.println("구매 금액을 입력해 주세요.");
        return scanInt();
    }

    public static int scanBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanInt();
    }

    public static int scanNumOfManualLottos() {
        System.out.println("\n수동으로 구매할 로또 수를 입력해 주세요.");
        return scanInt();
    }

    public static String[] scanWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanStringArray();
    }

    public static List<Lotto> scanManualLottoNumbers(int num) {
        List<Lotto> lottos = new ArrayList<>();

        if(num <= 0) {
            return lottos;
        }

        System.out.println("\n수동으로 구매할 번호를 입력해 주세요.");

        for(int i=0; i<num; i++) {
            lottos.add(Lotto.of(scanStringArray()));
        }

        return lottos;
    }

    private static int scanInt() {
        int input;

        try {
            input = scanner.nextInt();
            scanner.nextLine();     // 버퍼에서 개행문자 제거
        } catch(InputMismatchException e) {
            scanner.nextLine();     // 버퍼에서 개행문자 제거
            System.out.println("숫자만 입력 가능합니다. 다시 입력해주세요.");

            return scanTotalPrice();
        }

        return input;
    }

    public static String[] scanStringArray() {
        String answer;

        try {
            answer = scanner.nextLine();
            answer = answer.replaceAll(BLANK_STRING, "");
        } catch(InputMismatchException e) {
            scanner.nextLine();     // 버퍼에서 개행문자 제거
            System.out.println("문자만 입력 가능합니다. 다시 입력해주세요.");

            return scanWinningNumbers();
        }

        return answer.split(LOTTO_NUMBER_DELIMITER);
    }
}
