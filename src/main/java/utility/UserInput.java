package utility;

import domain.*;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class UserInput {
    private static final String BUY_MESSEGE = "구입금액을 입력해 주세요.";
    private static final String PURCHASE_MESSEGE = "개를 구매했습니다.";
    private static final String AFTER_MESSEGE = "지난 주 당첨 번호를 입력하세요.";
    private static final String DELIMTER = ",";
    private static final String BONUS_MESSEGE = "보너스 볼을 입력해 주세요.";
    private static final String MANUAL_MESSEGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String MANUAL_INPUT= "수동으로 구매할 번호를 입력해 주세요.";

    public static final int WON = 1000;
    public static final Scanner SC = new Scanner(System.in);

    private UserInput() {
    }

    public static Money tellHowManyBuy() {
        System.out.println(BUY_MESSEGE);
        int input = SC.nextInt();
        SC.nextLine();

        return new Money(input);
    }

    public static int tellHoWManyManualBuy() {
        System.out.println(MANUAL_MESSEGE);
        int manual = SC.nextInt();
        SC.nextLine();
        System.out.println(MANUAL_INPUT);

        return manual;
    }

    public static WinnerNumber getWinnerTicket() {
        String[] winnerNumber = inputWinnerNumber();
        int bonusNumber = inputBonusNumber();

        return new WinnerNumber(winnerNumber, bonusNumber);
    }

    private static String[] inputWinnerNumber() {
        System.out.println(AFTER_MESSEGE);
        String input = SC.nextLine();
        String[] inputs = input.split(DELIMTER);

        return inputs;
    }

    public static int inputBonusNumber() {
        System.out.println(BONUS_MESSEGE);

        return SC.nextInt();
    }

    public static Lottos createManualLotto(int manualTries) {
        Set<LottoNo> manualLotto;
        Lottos lottos = new Lottos();
        String[] inputs;

        for (int i = 0; i < manualTries; i++) {
            inputs = SC.nextLine().split(",");
            manualLotto = Arrays.stream(inputs)
                    .mapToInt(Integer::parseInt)
                    .mapToObj(e->new LottoNo(e))
                    .collect(Collectors.toSet());

            lottos.addLotto(new Lotto(manualLotto));
        }
        return lottos;
    }
}
