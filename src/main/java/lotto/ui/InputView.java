package lotto.ui;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Lottos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    static final String PURCHASE_AMOUNT = "구입금액을 입력해주세요.";
    static final String LOTTO_COUNT = "개를 구매했습니다.";
    static final String LAST_WEEK_LOTTO_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    static final String LOTTO_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";
    static final String MANUAL_LOTTO_COUNT = "수동으로 구매할 로또 수를 입력해 주세요.";
    static final String MANUAL_LOTTO_NUMBER = "수동으로 구매할 번호를 입력해 주세요.";
    static final String MANUAL_CANNOT_BE_GREATER_THEN_BUY_LOTTO = "수동으로 구매할 로또가 총 수량을 넘을수 없습니다.";

    static final int LOTTO_AMOUNT = 1000;

    public int buyOfLottoPrice() {
        System.out.println(PURCHASE_AMOUNT);
        String price = SCANNER.nextLine();
        return getLottoCount(price);
    }

    public int buyOfManualLotto(int lottoCount){
        System.out.println(MANUAL_LOTTO_COUNT);
        int manualLottoCount = Integer.parseInt(SCANNER.nextLine())/LOTTO_AMOUNT;
        if(lottoCount < manualLottoCount){
            throw new IllegalArgumentException(MANUAL_CANNOT_BE_GREATER_THEN_BUY_LOTTO);
        }

        return manualLottoCount;
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

    public LottoNumber getLastWeekBonusLottoNumber() {
        System.out.println(LOTTO_BONUS_NUMBER);
        String str = SCANNER.nextLine();
        LottoNumber lottoNumber = new LottoNumber(Integer.parseInt(str));
        return lottoNumber;
    }

    public Lottos getManualLottoNNumbers(int manualLottoCount){
        System.out.println(MANUAL_LOTTO_NUMBER);
        List<Lotto> lottoList = new ArrayList<>();
        StringBuilder inputLines = new StringBuilder();
        for (int i = 0; i < manualLottoCount; i++) {
            String line = SCANNER.nextLine();
            inputLines.append(line).append("\n");
            List<String> strList = List.of(line.replaceAll(" ", "").split(","));
            List<Integer> result = strList.stream()
                    .map(Integer::valueOf)
                    .collect(Collectors.toList());
            Lotto lotto = new Lotto(result);
            lottoList.add(lotto);
        }
        return new Lottos(lottoList);
    }
}
