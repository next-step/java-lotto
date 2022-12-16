package lotto.view;

import lotto.domain.LottoNumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {

    private static final String SEPARATOR = ",";
    private static final String BUY_MONEY_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String LUCKY_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String LUCKY_BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해주세요.";
    private static final String LOTTO_NUMBER_MESSAGE = "수동으로 구매하실 로또번호를 입력해주세요.";
    private static final String MANUAL_LOTTO_COUNT = "수동으로 구매하실 로또 개수를 입력해주세요";
    private static final Scanner sc = new Scanner(System.in);

    public static int inputBuyMoney(){
        System.out.println(BUY_MONEY_INPUT_MESSAGE);
        return Integer.parseInt(sc.nextLine());
    }

    public static int inputManualLottoCount(){
        System.out.println(MANUAL_LOTTO_COUNT);
        return Integer.parseInt(sc.nextLine());
    }

    public static List<Integer> inputLottoNumber(){
        return null;
    }

    public static List<Integer> inputLuckyNumber(){
        System.out.println(LUCKY_NUMBER_MESSAGE);
        return Arrays.stream(sc.nextLine().split(SEPARATOR))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static int bonusNumber(){
        System.out.println(LUCKY_BONUS_NUMBER_MESSAGE);
        return sc.nextInt();
    }

}
