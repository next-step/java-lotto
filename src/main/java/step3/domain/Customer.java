package step3.domain;

import step3.util.Rank;

import java.util.ArrayList;
import java.util.HashMap;

public class Customer {
    private static final LottoMachine lottoMachine = new LottoMachine();
    private static int resultPrize = 0;

    private HashMap<Rank, Integer> resultRankMap = new HashMap<>();

    public Customer() {
        preareRankMap();
    }

    private void preareRankMap() {
        for (Rank rank: Rank.values()) {
            resultRankMap.put(rank,0);
        }
    }

    public ArrayList<ArrayList<Integer>> buyLotto(int numOfLotto) {
        return lottoMachine.issue(numOfLotto);
    }

    public void compareWinningLottoNumbersAndIssuedLottoList(ArrayList<Integer> winningLottoNumberList, ArrayList<ArrayList<Integer>> issuedLottoList, int bonusNumber) {
        int numOfLotto = issuedLottoList.size();
        for (int i = 0; i < numOfLotto; i++) {
            System.out.println(issuedLottoList.get(i));
            getMatchedNumber(issuedLottoList.get(i), winningLottoNumberList, bonusNumber);
        }
    }

    public int getResultPrize() {
        return resultPrize;
    }

    public HashMap<Rank, Integer> getResultRankMap() {
        return resultRankMap;
    }

    public void getMatchedNumber(ArrayList<Integer> issuedLotto, ArrayList<Integer> winningLottoNumberList, int bonusNumber) {
        boolean isMatched = false;
        isMatched = compareWithBonusBall(issuedLotto, bonusNumber);

        issuedLotto.retainAll(winningLottoNumberList);
        int matchedNumber = issuedLotto.size();

        Rank rank = Rank.valueOf(matchedNumber, isMatched);
        resultRankMap.put(rank,resultRankMap.get(rank)+1);
        resultPrize += rank.getWinningMoney();
    }

    private boolean compareWithBonusBall(ArrayList<Integer> issuedLotto, int bonusNumber) {
        return issuedLotto.contains(bonusNumber);
    }


}
