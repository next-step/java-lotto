package lotto.ui;

import java.util.Scanner;

public class InputView {

    static Scanner SCANNER = new Scanner(System.in);

    static final String PURCHASE_AMOUNT = "구입금액을 입력해주세요.";

    static final String LOTTO_COUNT = "개를 구매했습니다.";
    static final String LAST_WEEK_LOTTO_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";

    public static int buyOfLottoPrice(){
        System.out.println(PURCHASE_AMOUNT);
        String price = SCANNER.nextLine();
        return getLottoCount(price);
    }

    private static int getLottoCount(String price){
        int lottoCount = Integer.parseInt(price)/1000;
        System.out.println(lottoCount+LOTTO_COUNT);
        return lottoCount;
    }

    public static String getLastWeekLottoNumber(){
        System.out.println(LAST_WEEK_LOTTO_NUMBER);
        return SCANNER.nextLine().replaceAll(" ", "");
    }
}
