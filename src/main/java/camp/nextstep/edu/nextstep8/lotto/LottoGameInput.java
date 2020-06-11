package camp.nextstep.edu.nextstep8.lotto;

import java.util.Scanner;

public class LottoGameInput {
    private static final Scanner SCANNER = new Scanner(System.in);
    public static int getPurchaseAmount() {
        System.out.println("구입 금액을 입력해 주세요");
        if(SCANNER.hasNextInt()) {
            return SCANNER.nextInt();
        }
        throw new IllegalArgumentException("구입 금액을 숫자로 정확히 입력해 주세요");
    }

    public static String getWinnerNumbersAtLastWeek() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요");
        if(SCANNER.hasNextLine()) {
            return SCANNER.next().trim();
        }
        throw new IllegalArgumentException("입력된 번호가 없습니다");
    }
}
