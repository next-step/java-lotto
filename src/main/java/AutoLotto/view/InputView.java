package AutoLotto.view;

import AutoLotto.domain.lotto.LottoNumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static AutoLotto.utils.Constants.*;


public class InputView {

    private static SystemInput systemIn = new SystemInput();

    private InputView(){}

    public static int getMoney() {
        System.out.println(ASK_MONEY);
        int money = systemIn.getIntValue();
        return money;
    }

    // 13?5?6 ... : 우선 정수인지만 regex 받고 : 그다음 lottoNumber 유효조건 확인
    public static List<LottoNumber> getBuzzLotto() {
        System.out.println(ASK_BUZZLOTTO_NUMBERS);
        String input = systemIn.getStringValue( );
        String[] tokens = input.split("");
        List<LottoNumber> buzzLotto = Arrays.stream(tokens)
                .map(token -> LottoNumber.checkLottoNumber(Integer.parseInt(token)))
                .map(i -> new LottoNumber(i))
                .collect(Collectors.toList());

        String buzzLottoToPrint = Arrays.stream(tokens)
                .map(token -> LottoNumber.checkLottoNumber(Integer.parseInt(token)))
                .map(i -> i.toString())
                .collect(Collectors.joining(", "));
        System.out.println(buzzLottoToPrint);
        return buzzLotto;
    }

}
