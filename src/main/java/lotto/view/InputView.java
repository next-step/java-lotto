package lotto.view;

import lotto.StringParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class InputView {

    /* 로또 구매 */
    private PurchaseLottoInput purchaseLottoInput;

    /* 당첨 번호 */
    private int bonusNumber;
    private Set<Integer> winningNumbers;

    private final Scanner sc;

    public InputView() {
        sc = new Scanner(System.in);
    }

    public void inputPurchaseLotto(){
        System.out.println("구입금액을 입력해 주세요.");
        int purchasePrice = toInteger(sc.nextLine());
        System.out.println();

        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int manualPurchaseCount = toInteger(sc.nextLine());
        System.out.println();

        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<String> manualLottoNumbers = toLottos(manualPurchaseCount);
        System.out.println();

        purchaseLottoInput = new PurchaseLottoInput(purchasePrice, manualLottoNumbers);
    }

    private List<String> toLottos(int manualPurchaseCount) {
        List<String> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < manualPurchaseCount; i++) {
            lottoNumbers.add(sc.nextLine());
        }
        return lottoNumbers;
    }

    public void inputWinningNumbersAndBonusNumber(){
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String input = sc.nextLine();
        winningNumbers = StringParser.getParseNumbers(input);
        System.out.println();

        System.out.println("보너스 볼을 입력해 주세요.");
        bonusNumber = sc.nextInt();
        System.out.println();
    }

    private int toInteger(String input){
        int number = 0;
        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("숫자 외에 입력할 수 없습니다.");
        }

        return number;
    }

    public int getPurchasePrice() {
        return purchaseLottoInput.getPurchasePrice();
    }

    public PurchaseLottoInput getPurchaseLottoInput() {
        return purchaseLottoInput;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public Set<Integer> getWinningNumbers() {
        return winningNumbers;
    }
}
