package domain;

import view.InputView;
import view.ResultView;

import java.util.List;

public class LottoGame {
    static final int MATCHTHREE = 3;
    static final int MATCHFOUR = 4;
    static final int MATCHFIVE = 5;
    static final int MATCHSIX = 6;
    static final int numberOfRewards = 4;

    private int list[];
    private LottoPapers lottoPapers;

    public LottoGame(int turn) {
        this.list = new int[numberOfRewards];
        this.lottoPapers = new LottoPapers(turn);
    }

    public int[] getList() {
        return this.list;
    }

    public LottoPapers getLottoPapers() {
        return this.lottoPapers;
    }

    public int[] putList() {
        return this.getList();
    }

    public static void main(String[] args) throws Exception {
        int turn = InputView.numberOfPurchase(InputView.purchasingAmount());
        ResultView.printNumberOfLottos(turn);

        LottoGame lottoGame = new LottoGame(turn);

        ResultView.printLottoNumbers(lottoGame.lottoPapers);

        WinningLotto winningLotto = new WinningLotto(InputView.typeLottoNumbers());
        lottoGame.playingLotto(lottoGame.lottoPapers, winningLotto);

        ResultView.printResult(lottoGame.putList(), turn * 1000);
    }

    public void playingLotto(LottoPapers lottoPapers, WinningLotto winningLotto) {
        int count;
        for(Lotto lotto : lottoPapers.putLottoPapers()) {
            count = 0;
            this.list = amountOfMatching(compareLotto(lotto, winningLotto, count));
        }
    }

    private int compareLotto(Lotto lotto, WinningLotto winningLotto, int count) {
        for(Integer i : winningLotto.putWinningNumber()) {
            count = isMatched(lotto.putLottoNumber(), i, count);
        }
        return count;
    }

    private int isMatched(List<Integer> lotto, Integer i, int count) {
        if(lotto.contains(i)) {
            count++;
        }
        return count;
    }

    private int[] amountOfMatching(int count) {
        int matchList[] = {MATCHTHREE, MATCHFOUR, MATCHFIVE, MATCHSIX};

        for (int i = 0; i < numberOfRewards; i++) {
            checkMatchCount(count >= matchList[i], i);
        }

        return list;
    }

    private void checkMatchCount(boolean condition, int i) {
        if (condition) {
            list[i] += 1;
        }
    }
}
