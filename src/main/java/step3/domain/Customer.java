package step3.domain;

import step3.util.Rank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Customer {
    private static int resultPrize = 0;

    private static final LottoMachine lottoMachine = new LottoMachine();
    private Map<Rank, Integer> resultRankMap = new HashMap<>();

    public Customer() {
        preareRankMap();
    }

    private void preareRankMap() {
        for (Rank rank: Rank.values()) {
            resultRankMap.put(rank,0);
        }
    }

    public List<List<Integer>> buyLotto(int numOfLotto) {
        return lottoMachine.issue(numOfLotto);
    }

    public void compareWinningLottoNumbersAndIssuedLottoList(List<Integer> winningLottoNumberList, List<List<Integer>> issuedLottoList, int bonusNumber) {
        int numOfLotto = issuedLottoList.size();
        for (int i = 0; i < numOfLotto; i++) {
            getMatchedNumber(issuedLottoList.get(i), winningLottoNumberList, bonusNumber);
        }
    }

    public int getResultPrize() {
        return resultPrize;
    }

    public Map<Rank, Integer> getResultRankMap() {
        return resultRankMap;
    }

    public void getMatchedNumber(List<Integer> issuedLotto, List<Integer> winningLottoNumberList, int bonusNumber) {
        boolean isMatched = false;

        winningLottoNumberList.retainAll(issuedLotto);
        int matchedNumber = winningLottoNumberList.size();

        isMatched = issuedLotto.contains(bonusNumber);


        Rank rank = Rank.valueOf(matchedNumber, isMatched);
        resultRankMap.put(rank,resultRankMap.get(rank)+1);
        resultPrize += rank.getWinningMoney();
    }
}
