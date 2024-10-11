package step3.uiView;

import step3.enums.InputMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    //로또를 구매할 금액을 입력받는다.
    public int inputMoney() {
        System.out.println(InputMessage.INPUT_MONEY.message());
        return scanner.nextInt();
    }

    //수동 로또를 구매할 개수를 입력받는다.
    public int inputManualLottoCount() {
        System.out.println(InputMessage.INPUT_MANUAL_LOTTO_NUM.message());
        return scanner.nextInt();
    }

    //수동 로또를 입력받아 출력한다.
    public List<String> inputManualLotto(int count) {
        System.out.println(InputMessage.INPUT_MANUAL_LOTTO.message());
        List<String> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(scanner.next());
        }
        return list;
    }

    //로또 당첨숫자를 입력받는다.
    public String inputPrizeNum() {
        System.out.println(InputMessage.INPUT_PRIZE_NUM.message());
        return scanner.next();
    }

    //로또의 보너스 번호를 입력받는다.
    public int inputBonusNum() {
        System.out.println(InputMessage.INPUT_BONUS_NUM.message());
        return scanner.nextInt();
    }

}
