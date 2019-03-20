package domain;

import view.InputView;

import java.util.*;

public class LottoGame {

    int lottoCount;
    private List<Lotto> lottos;
    private Lotto winner;
    private List<LottoResult> lottoResult = new ArrayList<LottoResult>();

    public LottoGame(int lottoCount) {
        this.lottoCount = lottoCount;
        lottos = new ArrayList<Lotto>(lottoCount);

        for (int i = 0 ; i < lottoCount ; i++) {
            lottos.add(new Lotto());
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getLottoCount(){
        return lottoCount;
    }

    public List<LottoResult> calculateMatch(List<Lotto> lottos, Lotto winner) {
        for(Lotto lotto:lottos){
            int numberOfMatch = compareSingleLotto(lotto, winner);
            lottoResult.add(new LottoResult(numberOfMatch,1));
        }
        return lottoResult;
    }

    private int compareSingleLotto(Lotto first, Lotto second) {
        List<Integer> numbers = first.getNumbers();
        int numberOfMatch = 0;
        for(int number : numbers) {
            if (second.getNumbers().contains(number)) numberOfMatch++;
        }
        return numberOfMatch;
    }


    public List<LottoResult> getLottoResult() {
        return lottoResult;
    }
}
