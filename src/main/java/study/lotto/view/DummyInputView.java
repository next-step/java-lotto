package study.lotto.view;


import study.lotto.domain.LottoNumber;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DummyInputView implements InputView{


    public BigDecimal inputPurchaseAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT_MESSAGE);
        System.out.println(10000);
        return BigDecimal.valueOf(10000);
    }

    public String inputWinningLotto() {
        System.out.println(INPUT_WINNING_LOTTO);
        String input = "1,2,3,4,5,6";
        System.out.println(input);

        return input;
    }

    public LottoNumber inputBonusNumber() {
        int number = 45;
        System.out.println(number);

        return LottoNumber.of(number);
    }

    public int inputSelfPickLottoCount() {
        System.out.println(INPUT_SELF_PICK_MESSAGE);
        int input = 2;
        System.out.println(input);

        return input;
    }

    public List<String> inputSelfPickLotto(int selfPickLottoCount) {
        System.out.println(INPUT_SELF_PICK_LOTTO);
        List<String> selfPick = new ArrayList<>();
        String firstInput = "1,2,3,4,5,6";
        String secondInput = "1,2,3,4,5,45";
        selfPick.add(firstInput);
        selfPick.add(secondInput);
        System.out.println(firstInput);
        System.out.println(secondInput);

        return selfPick;
    }
}
