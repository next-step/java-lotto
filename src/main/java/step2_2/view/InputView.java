package step2_2.view;

import static java.util.stream.Collectors.toList;
import static step2_2.view.InputUtil.readInt;
import static step2_2.view.InputUtil.readNumbers;

import java.util.List;
import step2_2.domain.Lotto;
import step2_2.domain.LottoNumber;
import step2_2.domain.Money;

public class InputView {

    private static final String MONEY_INPUT_MESSAGE = "구입금액을 입력해주세요";
    private static final String LOTTO_NUMBER_INPUT_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";

    private InputView() {
    }

    public static Money readMoney() {
        System.out.println(MONEY_INPUT_MESSAGE);
        try {
            return new Money(readInt());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return readMoney();
        }
    }

    public static Lotto readLotto() {
        System.out.println(LOTTO_NUMBER_INPUT_MESSAGE);
        try {
            return new Lotto(readLottoNumbers());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return readLotto();
        }
    }

    private static List<LottoNumber> readLottoNumbers() {
        return readNumbers().stream()
            .map(LottoNumber::new)
            .collect(toList());
    }
}
