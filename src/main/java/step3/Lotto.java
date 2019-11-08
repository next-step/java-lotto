package step3;

import java.util.*;

public class Lotto {

    static final int LOTTO_NUMBER_MIN = 1;
    static final int LOTTO_NUMBER_MAX = 45;
    static int lottoBonusNumber;

    private List<Integer> lotto;

    public Lotto(List<Integer> lotto) {
        this.lotto = new ArrayList<>(lotto);
    }

    public static Lotto creatLottoWinningNumbers(String[] inputNewLottoNumbers) {
        checkWinningNumberLength(inputNewLottoNumbers);
        checkOverlapWinningNumber(inputNewLottoNumbers);

        return new Lotto(checkWinningNumberRange(inputNewLottoNumbers));
    }

    public static List<Integer> valueOf(Lotto lotto) {
        return lotto.lotto;
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

    public static List<Integer> lotteryStatics(Set<Lotto> purchasedLottos, List<Integer> winningNumbers) {
        List<Integer> resultMatching = new ArrayList<>();
        for (Lotto purchasedLotto : purchasedLottos) {
            resultMatching.add(matchWinningNumbers(purchasedLotto, winningNumbers));
        }
        return resultMatching;
    }

    private static int matchWinningNumbers(Lotto purchasedLotto, List<Integer> winningNumbers) {
        final int count = (int) winningNumbers.stream()
                .filter(purchasedLotto.lotto::contains)
                .count();
        return count;
    }

    public static void pickOutBonusWinningLotto(Set<Lotto> purchasedLottos) {
        int indexCount = 0;
        for (Lotto purchasedLotto : purchasedLottos) {
            LottoLottery.purchasedLottoCompareBonusNumber(purchasedLotto.lotto, indexCount);
            indexCount++;
        }
    }
}
