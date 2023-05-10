package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final String BUY_LOTTO_OF_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String LOTTO_NUMBER_OF_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String LOTTO_BONUS_NUMBER_OF_MESSAGE = "보너스 볼을 입력해 주세요.";
    private static final String BUY_NO_AUTO_LOTTO_OF_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String LOTTO_NO_AUTO_NUMBER_OF_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";
    private Scanner INPUT;

    public InputView(Scanner scanner) {
        this.INPUT = scanner;
    }

    public String setBuyLottoPrice() {
        System.out.println(BUY_LOTTO_OF_MESSAGE);

        return INPUT.nextLine();
    }

    public String setLottoResultNumber() {
        System.out.println(LOTTO_NUMBER_OF_MESSAGE);

        return INPUT.nextLine();
    }

    public int setLottoBonusNumber() {
        System.out.println(LOTTO_BONUS_NUMBER_OF_MESSAGE);

        return INPUT.nextInt();
    }

    public int setNoAutoBuyLottoCount() {
        System.out.println(BUY_NO_AUTO_LOTTO_OF_MESSAGE);

        return INPUT.nextInt();
    }

    public List<String> setNoAutoLottoNumbers(int count) {
        System.out.println(LOTTO_NO_AUTO_NUMBER_OF_MESSAGE);

        List<String> noAutoNumbers = new ArrayList<>();
        for(int i = 0; i < count; i++) {
            noAutoNumbers.add(INPUT.nextLine());
        }

        return noAutoNumbers;
    }
}
