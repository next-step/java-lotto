package lotto.application;

import lotto.domain.Lotto;
import lotto.domain.LottoNumbers;
import lotto.util.StringUtil;

import java.util.ArrayList;
import java.util.List;

public class PlayLotto {
    private static int LOTTO_PRICE = 1000;
    private static int WINNING_TOTAL_INDEX = 5;
    private static int FIRST_WINNING_MONEY = 200000000;
    private static int SECOND_WINNING_MONEY = 1500000;
    private static int THIRD_WINNING_MONEY = 50000;
    private static int FOURTH_WINNING_MONEY = 5000;
    private static int NONE_MONEY = 0;
    private static int FIRST_INDEX = 1;
    private static int SECOND_INDEX = 2;
    private static int THIRD_INDEX = 3;
    private static int FOURTH_INDEX = 4;

    public static int calculateLottoCount(int cash) {
        if(cash % 1000 == 0) {
            throw new RuntimeException("1000원 단위로 입력하세요.");
        }
        return cash / LOTTO_PRICE;
    }

    public static List<Lotto> createLotto(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for(int i=0; i<lottoCount; i++){
            lottos.add(new Lotto(new CreateShffledLottoNumbers()));
        }
        return lottos;
    }

    public static int[] playLotto(String winningNumberString, List<Lotto> lottos){
        Lotto winningLotto = createWinningLotto(winningNumberString);
        int[] winningArray = new int[WINNING_TOTAL_INDEX];
        for (Lotto lotto : lottos) {
            winningArray[winningLotto.checkWinning(lotto)]++;
        }
        return winningArray;
    }

    private static Lotto createWinningLotto(String winningNumberString) {
        List<Integer> winningNumberList = StringUtil.StringArrayToIntegerList(StringUtil.separator(winningNumberString));
        LottoNumbers winningLottoNumbers = new LottoNumbers(winningNumberList);
        return new Lotto(winningLottoNumbers);
    }


    public static double calculateProfitRate(int cash, int[] winningArray) {
        int totalMoney = 0;
        for (int index = 0; index < winningArray.length; index++) {
            totalMoney += calculate(index, winningArray[index]);
        }
        return Math.round((((float) totalMoney / cash) * 100)) / 100.0;
    }

    private static int calculate(int winningIndex, int count) {
        if (winningIndex == FOURTH_INDEX) {
            return calculateFourth(count);
        }
        if (winningIndex == THIRD_INDEX) {
            return calculateThird(count);
        }
        if (winningIndex == SECOND_INDEX) {
            return calculateSecond(count);
        }
        if (winningIndex == FIRST_INDEX) {
            return calculateFirst(count);
        }
        return NONE_MONEY;
    }

    private static int calculateFirst(int count) {
        return count * FIRST_WINNING_MONEY;
    }

    private static int calculateSecond(int count) {
        return count * SECOND_WINNING_MONEY;
    }

    private static int calculateThird(int count) {
        return count * THIRD_WINNING_MONEY;
    }

    private static int calculateFourth(int count) {
        return count * FOURTH_WINNING_MONEY;
    }
}
