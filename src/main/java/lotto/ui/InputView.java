package lotto.ui;

import lotto.domain.Lotto;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    static final String PURCHASE_AMOUNT = "구입금액을 입력해주세요.";
    static final String LOTTO_COUNT = "개를 구매했습니다.";
    static final String LAST_WEEK_LOTTO_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    static final String LOTTO_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";
    
    static final int LOTTO_AMOUNT = 1000;

    public int buyOfLottoPrice() {
        System.out.println(PURCHASE_AMOUNT);
        String price = SCANNER.nextLine();
        return getLottoCount(price);
    }

    private int getLottoCount(String price) {
        int lottoCount = Integer.parseInt(price) / LOTTO_AMOUNT;
        System.out.println(lottoCount + LOTTO_COUNT);
        return lottoCount;
    }

    public Lotto getLastWeekLottoNumber() {
        System.out.println(LAST_WEEK_LOTTO_NUMBER);
        List<String> strList = List.of(SCANNER.nextLine().replaceAll(" ", "").split(","));
        List<Integer> result = strList.stream()
                .map(Integer::valueOf)
                .collect(Collectors.toList());
        Lotto lotto = new Lotto(result);
        return lotto;
    }

    public String getLastWeekBonusLottoNumber() {
        System.out.println(LOTTO_BONUS_NUMBER);
        return SCANNER.nextLine();
    }
}
