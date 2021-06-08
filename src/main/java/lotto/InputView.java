package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    private static final String START_WORDING = "구입금액을 입력해주세요";
    private static final String MANUAL_LOTTO_WORDING = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String MANUAL_LOTTO_NUMBER_WORDING = "수동으로 구매할 번호를 입력해 주세요.";

    private static final String LAST_WEEK_WIN_NUMBER_WORDING = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_WORDING = "보너스 볼을 입력해 주세요.";


    public static Money getBuyingMoney() {
        System.out.println(START_WORDING);
        String input = SCANNER.nextLine();
        int inputNumber = Integer.parseInt(input);
        return new Money(inputNumber);
    }

    public static BuyingCount getManualLottoCount() {
        System.out.println(MANUAL_LOTTO_WORDING);
        String input = SCANNER.nextLine();
        return new BuyingCount(Integer.parseInt(input));
    }

    public static List<Lotto> getManualLottoNumber(BuyingCount manualLottoCount) {
        List<Lotto> lottoList = new ArrayList<>();
        System.out.println(MANUAL_LOTTO_NUMBER_WORDING);
        for (int i = 0; i < manualLottoCount.buyingCount(); i++) {
            String input = SCANNER.nextLine();
            lottoList.add(convertWinNumberStringToLotto(input));
        }
        return lottoList;
    }

    public static WinningLotto getLastWeekWinNumber() {
        System.out.println(LAST_WEEK_WIN_NUMBER_WORDING);
        String input = SCANNER.nextLine();
        return convertWinNumberStringToIntegerList(input);
    }

    public static LottoNumber getBonusWinNumber() {
        System.out.println(BONUS_NUMBER_WORDING);
        String input = SCANNER.nextLine();
        int number = Integer.parseInt(input);
        return new LottoNumber(number);
    }

    public static Lotto convertWinNumberStringToLotto(String lottoInput) {
        String[] splitString = lottoInput.split(",");
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (String s : splitString) {
            int number = Integer.parseInt(s);
            lottoNumbers.add(new LottoNumber(number));
        }
        return new Lotto(lottoNumbers);
    }

    public static WinningLotto convertWinNumberStringToIntegerList(String winNumber) {
        String[] splitString = winNumber.split(",");
        List<LottoNumber> winNumberList = new ArrayList<>();
        for (String s : splitString) {
            int number = Integer.parseInt(s);
            winNumberList.add(new LottoNumber(number));
        }
        return new WinningLotto(winNumberList);
    }

}
