package step2.view;

import step2.domain.lotto.Lotto;
import step2.domain.lotto.LottoNumber;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String NUMBER_OF_MONEY = "구입금액을 입력해 주세요.";
    private static final String NUMBER_OF_LOTTO = "지난 주 당첨 번호를 입력 해 주세요";
    private static final String NUMBER_OF_BONUS = "지난 주 보너스번호를 입력 해 주세요";

    public static int inputMoney() {
        System.out.println(NUMBER_OF_MONEY);
        return scanner.nextInt();
    }

    public static Lotto inputWinOfLottoNumber() {
        System.out.println(NUMBER_OF_LOTTO);
        String winOfLottoNum = scanner.next();

        return Lotto.create(Stream.of(winOfLottoNum.split(","))
            .map(Integer::parseInt)
            .map(LottoNumber::new)
            .collect(Collectors.toList()));
    }

    public static LottoNumber inputBonusOfLottoNumber() {
        System.out.println(NUMBER_OF_BONUS);
        int winOfLottoNum = scanner.nextInt();
        return new LottoNumber(winOfLottoNum);
    }

}
