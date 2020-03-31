package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String MONEY_INSERT = "구입금액을 입력해 주세요.";
    private static final String MANUAL_PURCHASE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String LOTTO_NUMBER_INPUT = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String LAST_WEEK_LOTTO_INPUT = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_BALL_INPUT = "보너스 볼을 입력해 주세요.";

    private Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public int getMoney() {
        System.out.println(MONEY_INSERT);

        return Integer.parseInt(scanner.nextLine());
    }

    public String getPurchaseLottoCount() {
        System.out.println(MANUAL_PURCHASE);

        return scanner.nextLine();
    }

    public List<String> getLottoNumbers(int purchaseCount) {
        List<String> lottoNumberValues = new ArrayList<>();

        System.out.println(LOTTO_NUMBER_INPUT);

        for(int i = 0; i < purchaseCount; i++) {
            lottoNumberValues.add(scanner.nextLine());
        }

        return lottoNumberValues;
    }

    public String getLastWeekLottoNumbers() {
        System.out.println(LAST_WEEK_LOTTO_INPUT);

        return scanner.nextLine();
    }

    public String getBonusBallNumber() {
        System.out.println(BONUS_BALL_INPUT);

        return scanner.nextLine();
    }

}
