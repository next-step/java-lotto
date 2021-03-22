package lotto.view;

import java.util.*;
import java.util.stream.Collectors;

public class InputView {

    private static final String SEPARATOR = ", ";
    private static final Scanner scanner = new Scanner(System.in);

    public int inputBuyAmount() {
        System.out.println("구매금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public int countManualLotto() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return scanner.nextInt();
    }

    public Map<Integer, List<Integer>> manualLottoNumber(int countManualLotto) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");

        scanner.nextLine();

        Map<Integer, List<Integer>> manualLottoNumbers = new LinkedHashMap<>();
        for (int count = 1; count <= countManualLotto; count++) {
            manualLottoNumbers.put(count, lottoNumber());
        }
        return manualLottoNumbers;
    }

    public List<Integer> inputWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return lottoNumber();
    }

    public List<Integer> lottoNumber() {
        return Arrays.stream(scanner.nextLine().split(SEPARATOR))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }

    public int bonusBall() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextInt();
    }
}
