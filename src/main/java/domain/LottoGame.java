package domain;

import view.InputView;
import view.ResultView;

import java.util.*;

public class LottoGame {
    static final int LOTTOBALLS = 6;
    static final int LOTTORANGE = 45;

    public LottoGame() {

    }

    public static void main(String[] args) throws Exception {
        int turn = InputView.numberOfPurchase(InputView.purchasingAmount());
        System.out.println(turn + "개를 구매했습니다.");
        Lotto lotto = new Lotto();

        for(int i = 0; i < turn; i++) {
            lotto.putLottoNumber(LottoGame.startGame());
        }

        ResultView.printLottoNumbers(lotto);
        System.out.println();
        lotto.winningLottoNumber(InputView.typeLottoNumbers());
        System.out.println();

        List<Integer> winningLotto = lotto.putWinningNumber();
        CompareLotto compareLotto = new CompareLotto();
        compareLotto.initCompareLotto();

        compareLotto.processingLotto(lotto, winningLotto);

        ResultView.printResult(compareLotto.getArrayOfLottoCheck(), turn * 1000);
    }

    public static List<Integer> startGame() {
        Set<Integer> set = new HashSet<>();
        List<Integer> lottoNum = new ArrayList<>();

        for(int i = 1; i <= LOTTORANGE; i++) {
            lottoNum.add(i);
        }

        Collections.shuffle(lottoNum);

        while(set.size() < LOTTOBALLS) {
            int index = set.size();
            set.add(lottoNum.get(index));
        }

        lottoNum = new ArrayList<>(set);
        Collections.sort(lottoNum);

        return lottoNum;
    }
}
