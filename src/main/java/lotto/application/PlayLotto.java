package lotto.application;

import lotto.domain.Lotto;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoPrize;
import lotto.util.StringUtil;

import java.util.ArrayList;
import java.util.List;

public class PlayLotto {
    private static int LOTTO_PRICE = 1000;
    private static int WINNING_TOTAL_INDEX = 6;

    public static int calculateLottoCount(int cash) {
        if (cash % LOTTO_PRICE != 0) {
            throw new RuntimeException("1000원 단위로 입력하세요.");
        }
        return cash / LOTTO_PRICE;
    }

    public static List<Lotto> createLotto(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto(new CreateShffledLottoNumbers()));
        }
        return lottos;
    }

    public static int[] playLotto(String winningNumberString, int bonusNumber, List<Lotto> lottos){
        Lotto winningLotto = createWinningLotto(winningNumberString, bonusNumber);
        int[] winningArray = new int[WINNING_TOTAL_INDEX];
        for (Lotto lotto : lottos) {
            winningArray[winningLotto.checkWinning(lotto)]++;
        }
        return winningArray;
    }

    private static Lotto createWinningLotto(String winningNumberString, int bonusNumber) {
        List<Integer> winningNumberList = StringUtil.stringArrayToIntegerList(StringUtil.separator(winningNumberString));
        LottoNumbers winningLottoNumbers = new LottoNumbers(winningNumberList);
        return new Lotto(winningLottoNumbers, bonusNumber);
    }


    public static double calculateProfitRate(int cash, int[] winningArray) {
        int totalMoney = 0;
        for (int index = 0; index < winningArray.length; index++) {
            totalMoney += calculate(index, winningArray[index]);
        }
        return Math.round((((float) totalMoney / cash) * 100)) / 100.0;
    }

    private static int calculate(int winningIndex, int count) {
        LottoPrize lottoPrize = LottoPrize.findLottoPrizeOfPrize(winningIndex);
        return lottoPrize.calculate(count);
    }
}
