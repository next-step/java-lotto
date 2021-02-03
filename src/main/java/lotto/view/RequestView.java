package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RequestView {

    public static final String REQUEST_PURCHASE_PRICE = "구입 금액을 입력해 주세요.";
    public static final String REQUEST_MANUAL_LOTTO_COUNT = "수동으로 구매할 로또 수를 입력해주세요.";
    public static final String REQUEST_MANUAL_LOTTO_NUMBER = "수동으로 구매할 번호를 입력해 주세요.";
    public static final String REQUEST_WINNING_PRICE = "지난 주 당첨 번호를 입력해 주세요. ex) 1, 2, 3, 4, 5, 6";
    public static final String REQUEST_BONUS_BALL = "보너스 볼을 입력해 주세요.";
    private final Scanner sc = new Scanner(System.in);

    public String requestPriceFromUser() {
        printRequestPriceFromUser();
        return sc.nextLine();
    }

    public String requestWinningNumber() {
        printRequestWinningNumber();
        return sc.nextLine();
    }

    public String requestBonusNumber() {
        printRequestBonusNumber();
        return sc.nextLine();
    }

    public String requestManualLottoCount() {
        printRequestManualLottoCount();
        return sc.nextLine();
    }

    public List<String> requestManualLottoNumber(int manualTicketCount) {
        printRequestManualLottoNumber();
        List<String> manualLottoNumbers = new ArrayList<>();
        for(int i = 0; i < manualTicketCount; i++){
            manualLottoNumbers.add(sc.nextLine());
        }
        return manualLottoNumbers;
    }

    private void printRequestPriceFromUser() {
        System.out.println(REQUEST_PURCHASE_PRICE);
    }
    private void printRequestManualLottoCount() {
        System.out.println(REQUEST_MANUAL_LOTTO_COUNT);
    }
    private void printRequestManualLottoNumber() {
        System.out.println(REQUEST_MANUAL_LOTTO_NUMBER);
    }

    private void printRequestWinningNumber() {
        System.out.println(REQUEST_WINNING_PRICE);
    }

    private void printRequestBonusNumber() {
        System.out.println(REQUEST_BONUS_BALL);
    }
}
