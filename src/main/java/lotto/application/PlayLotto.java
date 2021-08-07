package lotto.application;

import lotto.domain.Lotto;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoPrize;
import lotto.util.StringUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PlayLotto {
    private static int LOTTO_PRICE = 1000;
    private static int WINNING_TOTAL_INDEX = 6;

    public static int calculateAutoLottoCount(int cash, int manualLottoCount) {
        validateArgument(cash,manualLottoCount);
        return cash / LOTTO_PRICE - manualLottoCount;
    }

    private static void validateArgument(int cash, int manualLottoCount) {
        if (cash <= 0) {
            throw new IllegalArgumentException("구입금액은 0원 이상으로 입력해주세요.");
        }
        if (cash % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("1000원 단위로 입력하세요.");
        }
        if (manualLottoCount < 0) {
            throw new IllegalArgumentException("수동으로 구매할 로또 수는 0이상이어야 합니다.");
        }
    }

    public static List<Lotto> createLotto(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto(new CreateShffledLottoNumbers()));
        }
        return lottos;
    }

    public static int[] playLotto(String winningNumberString, int bonusNumber, List<Lotto> lottos) {
        Lotto winningLotto = createWinningLotto(winningNumberString, bonusNumber);
        int[] winningArray = new int[WINNING_TOTAL_INDEX];
        for (Lotto lotto : lottos) {
            winningArray[winningLotto.checkWinning(lotto)]++;
        }
        return winningArray;
    }

    private static Lotto createWinningLotto(String winningNumberString, int bonusNumber) {
        LottoNumbers winningLottoNumbers = createLottoNumbers(winningNumberString);
        return new Lotto(winningLottoNumbers, bonusNumber);
    }

    private static LottoNumbers createLottoNumbers(String winningNumberString) {
        List<Integer> winningNumberList = StringUtil.stringArrayToIntegerList(StringUtil.separator(winningNumberString));
        return new LottoNumbers(winningNumberList);
    }


    public static double calculateProfitRate(int cash, int[] winningArray) {
        int totalMoney = 0;
        for (int index = 0; index < winningArray.length; index++) {
            totalMoney += calculate(index, winningArray[index]);
        }
        return Math.round((((double) totalMoney / cash) * 100)) / 100.0;
    }

    private static int calculate(int winningIndex, int count) {
        LottoPrize lottoPrize = LottoPrize.findLottoPrizeOfPrize(winningIndex);
        return lottoPrize.calculate(count);
    }

    public static List<Lotto> createManualLotto(List<String> manualLottoNumbers) {
        List<Lotto> manualLottos = new LinkedList<>();
        for (String manualLottoNumber : manualLottoNumbers) {
            manualLottos.add(new Lotto(createLottoNumbers(manualLottoNumber)));
        }
        return manualLottos;
    }
}
