package step3.view;

import step3.domain.lotto.LottoNumber;
import java.util.List;
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

    public static List<LottoNumber> inputWinOfLottoNumber() {
        System.out.println(NUMBER_OF_LOTTO);
        String winOfLottoNum = scanner.next();
        System.out.println(winOfLottoNum);
        return Stream.of(winOfLottoNum.split(","))
            .map(Integer::parseInt)
            .map(LottoNumber::new)
            .collect(Collectors.toList());
    }

    public static LottoNumber inputBonusOfLottoNumber() {
        System.out.println(NUMBER_OF_BONUS);
        int winOfLottoNum = scanner.nextInt();
        System.out.println(winOfLottoNum);
        return new LottoNumber(winOfLottoNum);
    }

}
