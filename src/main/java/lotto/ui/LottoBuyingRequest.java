package lotto.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LottoBuyingRequest {
    private final int buyingPrice;
    private final int numberOfManualLotto;
    private final List<String> manualLottoNumbers;

    public LottoBuyingRequest(int buyingPrice, int numberOfManualLotto, List<String> manualLottoNumbers) {
        this.buyingPrice = buyingPrice;
        this.numberOfManualLotto = numberOfManualLotto;
        this.manualLottoNumbers = manualLottoNumbers;
    }

    public static LottoBuyingRequest create() {
        Scanner sc = new Scanner(System.in);
        int buyingPrice = inputBuyingPrice(sc);
        int numberOfBuyingLotto = inputNumberOfBuyingLotto(sc);
        List<String> manualLottoNumbers = inputManualLottoNumbers(sc, numberOfBuyingLotto);
        return new LottoBuyingRequest(buyingPrice, numberOfBuyingLotto, manualLottoNumbers);
    }

    private static int inputBuyingPrice(Scanner sc) {
        System.out.println("구매금액을 입력해 주세요.");
        int buyingPrice = sc.nextInt();
        sc.nextLine();
        return buyingPrice;
    }

    private static int inputNumberOfBuyingLotto(Scanner sc) {
        System.out.println("수동으로 구매할 로또 수를 입력해주세요.");
        int numberOfManualLotto = sc.nextInt();
        sc.nextLine();
        return numberOfManualLotto;
    }

    private static List<String> inputManualLottoNumbers(Scanner sc, int numberOfManualLotto) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");

        List<String> manualLottoNumbers = new ArrayList<>();

        for (int i = 0; i < numberOfManualLotto; i++) {
            String manualLottoNumber = sc.nextLine();
            manualLottoNumbers.add(manualLottoNumber);
        }

        return manualLottoNumbers;
    }

    public int getBuyingPrice() {
        return buyingPrice;
    }


    public int getNumberOfManualLotto() {
        return numberOfManualLotto;
    }

    public List<String> getManualLottoNumbers() {
        return manualLottoNumbers;
    }
}
