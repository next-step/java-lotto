package lotto.view;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String NUMBER_SPLIT_EXPRESSION = ",";

    private static final String PURCHASE_PRICE_COMMENT = "구입금액을 입력해 주세요.";
    private static final String LASTWEEK_LOTTO_PRIZE_NUMBER_COMMENT = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_BALL_COMMENT = "보너스 볼을 입력해 주세요.";


    private static final String MANUAL_LOTTO_COUNT_COMMENT = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String MANUAL_LOTTO_NUMBER_COMMENT = "수동으로 구매할 번호를 입력해 주세요.";

    private InputView() {
    }

    public static int inputPurchasePrice() {
        System.out.println(PURCHASE_PRICE_COMMENT);

        int purchasePrice = scanner.nextInt();
        validateLottoMinPrice(purchasePrice);
        return purchasePrice;
    }

    private static void validateLottoMinPrice(int purchasePrice) {
        if (purchasePrice < 1000) {
            throw new IllegalArgumentException();
        }
    }

    public static int inputManualLottoCount() {
        System.out.println();
        System.out.println(MANUAL_LOTTO_COUNT_COMMENT);
        return scanner.nextInt();
    }

    public static void inputManualLottoNumbers() {
        System.out.println();
        System.out.println(MANUAL_LOTTO_NUMBER_COMMENT);
    }

    public static Set<Integer> inputLottoNumbers(){
        String[] splitManualLottoNumber = scanner.next().split(NUMBER_SPLIT_EXPRESSION);
        return parseArrayToSet(splitManualLottoNumber);
    }

    public static Set<Integer> lastWeekLottoPrizeNumber() {
        System.out.println();
        System.out.println(LASTWEEK_LOTTO_PRIZE_NUMBER_COMMENT);
        String[] splitPrizeNumber = scanner.next().split(NUMBER_SPLIT_EXPRESSION);
        return parseArrayToSet(splitPrizeNumber);
    }

    private static Set<Integer> parseArrayToSet(String[] rowData){
        return Stream.of(rowData)
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(HashSet::new));
    }

    public static int inputBonusball() {
        System.out.println(BONUS_BALL_COMMENT);
        return scanner.nextInt();
    }
}