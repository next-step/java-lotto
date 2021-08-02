package lotto.application;

import lotto.domain.Lotto;
import lotto.domain.LottoNumbers;
import lotto.util.StringUtil;

import java.util.ArrayList;
import java.util.List;

public class PlayLotto {
    private static int LOTTO_PRICE = 1000;
    private static int WINNING_TOTAL_INDEX = 5;

    public static List<Lotto> createLotto(int cash) {
        List<Lotto> lottos = new ArrayList<>();
        int lottoCount = cash / LOTTO_PRICE;
        for(int i=0; i<lottoCount; i++){
            lottos.add(new Lotto(new CreateShffledLottoNumbers()));
        }
        return lottos;
    }

    public static int[] playLotto(String winningNumberString, List<Lotto> lottos){
        Lotto winningLotto = createWinningLotto(winningNumberString);
        int[] prize = new int[WINNING_TOTAL_INDEX];
        for (Lotto lotto : lottos) {
            prize[winningLotto.checkWinning(lotto)]++;
        }
        return prize;
    }

    private static Lotto createWinningLotto(String winningNumberString) {
        List<Integer> winningNumberList = StringUtil.StringArrayToIntegerList(StringUtil.separator(winningNumberString));
        LottoNumbers winningLottoNumbers = new LottoNumbers(winningNumberList);
        return new Lotto(winningLottoNumbers);
    }


}
