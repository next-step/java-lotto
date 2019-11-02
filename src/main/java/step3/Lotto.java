package step3;

import java.util.*;

public class NewLotto {

    static final int LOTTO_NUMBER_MIN = 1;
    static final int LOTTO_NUMBER_MAX = 45;
    static int lottoBonusNumber;

    private List<Integer> newLotto;

    public NewLotto(List<Integer> newLotto) {
        this.newLotto = new ArrayList<>(newLotto);
    }

    public static NewLotto creatLottoWinningNumbers2(String[] inputNewLottoNumbers) {
        checkWinningNumberLength(inputNewLottoNumbers);
        checkOverlapWinningNumber(inputNewLottoNumbers);

        return new NewLotto(checkWinningNumberRange(inputNewLottoNumbers));
    }

    public static List<Integer> valueOf(NewLotto newLotto) {
        return newLotto.newLotto;
    }

    public static void checkWinningNumberLength(String[] inputNewLottoNumbers) {
        if (inputNewLottoNumbers.length != LottoGenerator.WINNING_NUMBERS_LENGTH)
            throw new IllegalArgumentException("당첨번호는" + LottoGenerator.WINNING_NUMBERS_LENGTH + "개를 입력하셔야 합니다.");
    }

    public static void checkOverlapWinningNumber(String[] inputNewLottoNumbers) {
        Set<String> uniqueWinningNumber = new HashSet<>(Arrays.asList(inputNewLottoNumbers));
        if (uniqueWinningNumber.size() != inputNewLottoNumbers.length)
            throw new IllegalArgumentException("당첨번호에 중복된 값이 있습니다.");
    }

    public static ArrayList<Integer> checkWinningNumberRange(String[] inputNewLottoNumbers) {
        ArrayList<Integer> inputWinningNumberList = new ArrayList<>();
        for (int i = 0; i < LottoGenerator.WINNING_NUMBERS_LENGTH; i++) {
            LottoNo.checkEachNumber(Integer.parseInt((inputNewLottoNumbers[i])));
            inputWinningNumberList.add(Integer.parseInt((inputNewLottoNumbers[i])));
        }
        Collections.sort(inputWinningNumberList);
        return inputWinningNumberList;
    }

    public static List<Integer> lotteryStatics2(Set<NewLotto> purchasedLottos, List<Integer> winningNumbers) {
        List<Integer> resultMatching = new ArrayList<>();
        for (NewLotto purchasedLotto : purchasedLottos) {
            resultMatching.add(matchWinningNumbers(purchasedLotto, winningNumbers));
        }
        return resultMatching;
    }

    private static int matchWinningNumbers(NewLotto purchasedLotto, List<Integer> winningNumbers) {
        final int count = (int) winningNumbers.stream()
                .filter(purchasedLotto.newLotto::contains)
                .count();
        return count;
    }

    public static void pickOutBonusWinningLotto(Set<NewLotto> purchasedLottos) {
        int indexCount = 0;
        for (NewLotto purchasedLotto : purchasedLottos) {
            LottoLottery.purchasedLottoCompareBonusNumber(purchasedLotto.newLotto, indexCount);
            indexCount++;
        }
    }
}
