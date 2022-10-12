package Lotto.view;

import Lotto.model.Lotto;
import Lotto.model.LottoNumber;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LottoInput {

    private static final String ASK_PRICE = "구입금액을 입력해 주세요";
    private static final String ASK_BONUMS_BALL = "보너스 볼을 입력해 주세요.";
    private static final String ASK_MANUAL_LOTTO_COUNT = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String DELIMITER = ", ";


    public static int getPrice() {
        System.out.println(ASK_PRICE);
        int price = Integer.parseInt(SCANNER.nextLine());
        System.out.println(price);
        return price;
    }

    public static int getManualLottoCount() {
        System.out.println(ASK_MANUAL_LOTTO_COUNT);
        int manualLottoCount = Integer.parseInt(SCANNER.nextLine());
        System.out.println(manualLottoCount);
        return manualLottoCount;
    }

    public static Lotto getLottoNumber() {
        return new Lotto(Arrays.asList(SCANNER.nextLine().split(DELIMITER)).stream().map(it -> new LottoNumber(Integer.parseInt(it))).collect(Collectors.toList()));
    }

    public static int getBonusNumber() {
        System.out.println(ASK_BONUMS_BALL);
        return Integer.parseInt(SCANNER.nextLine());
    }

}
