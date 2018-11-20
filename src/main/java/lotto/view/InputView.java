package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoNo;

import java.util.*;

public class InputView {
    private static final int PICK_NUMBER_COUNT = 6;

    public static int inputCost() {
        Scanner sc = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");
        return sc.nextInt();
    }

    public static int inputManualLottoCount() {
        Scanner sc = new Scanner(System.in);
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return sc.nextInt();
    }

    public static String[] inputManualLottos(int manualLottoCount) {
        Scanner sc = new Scanner(System.in);
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        String[] inputManualLotto = new String[manualLottoCount];
        for(int i = 0; i < manualLottoCount; i++) {
            inputManualLotto[i] = sc.next();
        }
        return inputManualLotto;
    }

    public static Lotto inputWinningLotto() {
        List<Integer> pickNumbers = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        StringTokenizer token = new StringTokenizer(sc.next(), ", ");

        return Lotto.from(split(pickNumbers, token));
    }

    public static LottoNo inputWinningBonus() {
        Scanner sc = new Scanner(System.in);
        System.out.println("보너스 볼을 입력해 주세요.");
        return LottoNo.of(sc.nextInt());
    }

    private static List<Integer> split(List<Integer> pickNumbers, StringTokenizer token) {
        for(int i = 0; i < PICK_NUMBER_COUNT; i++) {
            pickNumbers.add(Integer.parseInt(token.nextToken()));
        }
        return pickNumbers;
    }

}
