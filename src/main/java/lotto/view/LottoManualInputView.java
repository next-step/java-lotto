package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LottoManualInputView {

    public int inputPrice() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("구입금액을 입력해 주세요.");

        int price = scanner.nextInt();
        checkPrice(price);
        return price;
    }

    private void checkPrice(int price) {
        if (price < 0) {
            throw new IllegalArgumentException("로또 구매 금액은 0 이상이어야 합니다.");
        }
    }

    public int inputManualLottoQuantity() {
        Scanner scanner = new Scanner(System.in);

        System.out.println();
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");

        int quantity = scanner.nextInt();
        checkQuantity(quantity);
        return quantity;
    }

    private void checkQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("수동 로또 수는 0 이상이어야 합니다.");
        }
    }

    public List<String> inputManualLottoNumbers(int manualQuantity) {
        Scanner scanner = new Scanner(System.in);

        List<String> manualNumbers = new ArrayList<>();

        System.out.println();
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        for (int i = 0; i < manualQuantity; i++) {
            manualNumbers.add(scanner.nextLine());
        }
        return manualNumbers;
    }

    public String inputWinningNumbers() {
        Scanner scanner = new Scanner(System.in);

        System.out.println();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

    public int inputBonusNumber() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextInt();
    }
}
