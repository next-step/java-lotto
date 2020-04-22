package Lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private final String PLEASE_INPUT_AMOUNT = "구입금액을 입력해 주세요.";
    private final String PLEASE_INPUT_MANUAL_COUNT = "수동으로 구매할 로또 수를 입력해 주세요.";
    private final String PLEASE_INPUT_MANUAL_GAME = "수동으로 구매할 번호를 입력해 주세요.";
    private final String PLEASE_INPUT_PRIZE_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    private final String PLEASE_INPUT_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";

    public Amount inputPurchasingAmount() {
        System.out.println(PLEASE_INPUT_AMOUNT);
        Scanner scanner = new Scanner(System.in);
        String amount = scanner.nextLine();
        return new Amount(amount);
    }

    public ManualLottoCount inputManualGameCount(Amount amount) {
        System.out.println(PLEASE_INPUT_MANUAL_COUNT);
        Scanner scanner = new Scanner(System.in);
        String count = scanner.nextLine();
        return new ManualLottoCount(count, amount);
    }

    public List<LottoNumbers> inputManualGame(ManualLottoCount manualLottoCount) {
        System.out.println(PLEASE_INPUT_MANUAL_GAME);
        Scanner scanner = new Scanner(System.in);
        String[] manuals = new String[manualLottoCount.getManualCount()];
        for (int i = 0; i < manuals.length; i++) {
            manuals[i] = scanner.nextLine();
        }

        List<LottoNumbers> lottoNumbersList = new ArrayList<>();
        for (int i = 0; i < manuals.length; i++) {
            String[] numbers = manuals[i].split(",");
            lottoNumbersList.add(addManualLottoNumbers(numbers));
        }

        return lottoNumbersList;
    }

    private LottoNumbers addManualLottoNumbers(String[] manualNumbers) {
        return new LottoNumbers(manualNumbers);
    }

    public List<Integer> inputPrizeNumber() {
        System.out.println(PLEASE_INPUT_PRIZE_NUMBER);
        Scanner scanner = new Scanner(System.in);
        String prizeNumber = scanner.nextLine();
        String[] temp = prizeNumber.split(",");

        List<Integer> prizeList = new ArrayList<>();
        for (String s : temp) {
            prizeList.add(Integer.parseInt(s));
        }

        return prizeList;
    }

    public int inputBonusNumber() {
        System.out.println(PLEASE_INPUT_BONUS_NUMBER);
        Scanner scanner = new Scanner(System.in);
        String bonusNumber = scanner.nextLine();

        return Integer.parseInt(bonusNumber);
    }

}
