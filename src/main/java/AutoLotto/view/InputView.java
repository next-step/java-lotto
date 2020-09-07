package AutoLotto.view;

import AutoLotto.domain.lotto.LottoNumber;
import AutoLotto.utils.CheckRegex;

import java.util.List;

import static AutoLotto.utils.Constants.*;


public class InputView {

    private static SystemInput systemIn = new SystemInput();

    private InputView(){}

    public static int getMoney() {
        System.out.println(ASK_MONEY);
        int money = systemIn.getIntValue();
        return money;
    }

    public static List<LottoNumber> getBuzzLotto() {
        System.out.println(ASK_BUZZLOTTO_NUMBERS);
        String input = systemIn.getStringValue( );
        List<LottoNumber> buzzLotto = CheckRegex.makeBuzzLotto(input);
//        buzzLotto.stream()
//                .mapToInt(lottoNumber -> lottoNumber.getLottoNumber())
//                .forEach(buzzNumber -> System.out.print(buzzNumber+" "));
        return buzzLotto;
    }
}
