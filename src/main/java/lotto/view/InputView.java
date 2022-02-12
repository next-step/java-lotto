package lotto.view;

import java.util.Scanner;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Lottos;

public class InputView {

    private static final String PURCHASE_AMOUNT_MESSAGE = "구입 금액을 입력해 주세요";
    private static final String WINNING_LOTTO_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUSBALL_MESSAGE = "보너스 볼을 입력해 주세요.";
    private static final String LOTTO_TICKET_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요";
    private static final String LOTTO_NUMBER_MANUAL_MESSAGE = "수동으로 구매할 번호를 입력해주세요.";
    private static final Scanner SCANNER = new Scanner(System.in);


    private InputView() {

    }

    public static String inputPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_MESSAGE);
        return SCANNER.nextLine();
    }

    public static String inputLottoTicket(){
        System.out.println(LOTTO_TICKET_MESSAGE);
        return SCANNER.nextLine();
    }

    public static String inputWinningLottoNumber() {
        System.out.println(WINNING_LOTTO_NUMBER_MESSAGE);
        return SCANNER.nextLine();
    }

    public static LottoNumber inputBonusLottoNumber() {
        System.out.println(BONUSBALL_MESSAGE);
        int bonusLottoNumber = Integer.parseInt(SCANNER.nextLine());
        return new LottoNumber(bonusLottoNumber);
    }

    public static Lottos inputPurchaseManualLotto(int count){
        System.out.println(LOTTO_NUMBER_MANUAL_MESSAGE);
        return new Lottos(inputLotto(), count);
    }

    public static Lotto inputLotto(){
        String numberOfPurchaseManual = SCANNER.nextLine();
        return new Lotto(numberOfPurchaseManual);
    }
}
