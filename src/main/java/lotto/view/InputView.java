package lotto.view;

import java.util.*;
import java.util.stream.Collectors;

public class InputView {
    public static int inputBuyPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);

        return scanner.nextInt();
    }

    public static int issueManualLottos() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static List<Set<Integer>> issueManualLottos(int manualQuantity) {
        if (manualQuantity < 0) {
            return List.of();
        }

        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        List<Set<Integer>> manualLottos = new ArrayList<>();

        for (int i = 0; i < manualQuantity; i++) {
            String inputNumbers = scanner.nextLine();
            Set<Integer> lotto = Arrays.stream(inputNumbers.replaceAll(" ", "").split(",")).map(Integer::valueOf).collect(Collectors.toSet());
            manualLottos.add(lotto);
        }
        return manualLottos;
    }


    public static int[] inputLastWeekWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        String inputWinningNumbers = scanner.nextLine();
        String[] splitWinningNumbers = inputWinningNumbers.replaceAll(" ", "").split(",");
        return Arrays.stream(splitWinningNumbers).mapToInt(Integer::parseInt).toArray();
    }

    public static int inputLastWeekBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.nextLine());
    }

}
