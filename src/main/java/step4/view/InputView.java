package step4.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final int PRICE_OF_A_LOTTO = 1000;
    private static final int LOWEST_PURCHASE_PRICE = 1000;
    private static final String DELIMITER = ", ";

    public static int getInputOfPurchasePrice() {
        System.out.println("구입금액을 입력해 주세요.");
        int purchasePrice = scanner.nextInt();

        validatePurchasePrice(purchasePrice);
        return purchasePrice;
    }

    private static void validatePurchasePrice(int purchasePrice) {
        if (purchasePrice < LOWEST_PURCHASE_PRICE) {
            throw new IllegalArgumentException(
                    String.format("최소 구입 금액은 %d원입니다.", LOWEST_PURCHASE_PRICE));
        }
    }

    public static int getInputOfNumberOfManualLotto(int purchasePrice) {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        scanner.nextLine(); // 입력 버퍼 비워주기
        int numberOfManualLotto = scanner.nextInt();

        validateNumberOfManualLotto(numberOfManualLotto, purchasePrice);
        return numberOfManualLotto;
    }

    private static void validateNumberOfManualLotto(int numberOfManualLotto, int purchasePrice) {
        if (PRICE_OF_A_LOTTO * numberOfManualLotto > purchasePrice) {
            throw new IllegalArgumentException("구입 금액 이상의 로또를 구매할 수 없습니다.");
        }
    }

    public static List<List<Integer>> getInputOfManualLottoNumbers(int numberOfManualLotto) {
        if (numberOfManualLotto > 0) {
            System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        }
        scanner.nextLine(); // 입력 버퍼 비워주기
        List<List<Integer>> manualLottos = new ArrayList<>();
        for (int i = 0; i < numberOfManualLotto; i++) {
            manualLottos.add(getLottoNumbers());
        }
        return manualLottos;
    }

    public static int printPurchaseAmount(int numberOfManualLotto, int purchasePrice) {
        int numberOfAutoLotto = getPurchaseAmount(purchasePrice) - numberOfManualLotto;
        System.out.printf("수동으로 %d장, 자동으로 %d장을 구매했습니다.%n", numberOfManualLotto, numberOfAutoLotto);
        return numberOfAutoLotto;
    }

    private static int getPurchaseAmount(int purchasePrice) {
        return purchasePrice / PRICE_OF_A_LOTTO;
    }

    public static List<Integer> getInputOfWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return getLottoNumbers();
    }

    private static List<Integer> getLottoNumbers() {
        String[] inputSplit = scanner.nextLine().split(DELIMITER);
        return toIntegerList(inputSplit);
    }

    private static List<Integer> toIntegerList(String[] inputSplit) {
        List<Integer> intList = new ArrayList<>();
        for (String numberString : inputSplit) {
            int number = Integer.parseInt(numberString);
            intList.add(number);
        }
        return intList;
    }

    public static int getInputOfBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextInt();
    }
}
