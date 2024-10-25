package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LottoInputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static int inputPaidAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public static List<Integer> inputWinningNumbers() {
        System.out.println("지난 주 당첨번호를 입력해주세요");
        return inputNumbers();
    }

    public static int inputBonusNumber() {
        System.out.println("보너스 볼을 입력해주세요");
        return scanner.nextInt();
    }

    public static int inputManualLottoCount(int totalLottoCount) {
        System.out.println("수동으로 구매할 로또 수를 입력해주세요");
        int manualLottoCount = scanner.nextInt();
        //todo 유효성 체크 위치
        if (totalLottoCount < manualLottoCount) {
            throw new IllegalArgumentException("구매할 수 있는 로또 수보다 수동으로 구매할 로또의 수가 더 많습니다.");
        }
        return manualLottoCount;
    }

    public static Lottos inputAllManualLottos(int manualLottoCount) {
        System.out.println("수동으로 구매할 번호를 입력해주세요");
        scanner.nextLine();
        List<Lotto> manualLottos = new ArrayList<>();
        for (int i = 0; i < manualLottoCount; i++) {
            manualLottos.add(new Lotto(inputNumbers()));
        }
        return new Lottos(manualLottos);
    }

    private static List<Integer> inputNumbers() {
        String numberStr = scanner.nextLine();
        List<Integer> numbers = Arrays.stream(numberStr.replaceAll(" ", "").split(","))
                .mapToInt(Integer::parseInt)
                .boxed().collect(Collectors.toList());

        return numbers;
    }

}
