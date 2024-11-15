package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    public static int readAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return readInt();
    }

    public static String readWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return read();
    }

    private static String read() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static int readBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return readInt();
    }

    private static int readInt() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static int readPassivityLottoCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static List<String> readPassivityLotts(int count) {
        validPassivityLottoCount(count);
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        ArrayList<String> result = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < count; i++) {
            result.add(scanner.nextLine());
        }
        return result;
    }

    private static void validPassivityLottoCount(int count) {
        if (count < 0) {
            throw new IllegalArgumentException("로또 발급 개수는 음수일 수 없습니다");
        }
    }
}
