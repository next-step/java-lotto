package step3.domain;

import java.util.ArrayList;
import java.util.HashSet;

public class Customer {
    private static final LottoMachine lottoMachine = new LottoMachine();

    public ArrayList<ArrayList<Integer>> buyLotto(int numOfLotto) {
        return lottoMachine.issue(numOfLotto);
    }

    public ArrayList<Integer> compareWinningLottoNumbersAndIssuedLottoList(ArrayList<Integer> winningLottoNumberList, ArrayList<ArrayList<Integer>> issuedLottoList) {
        ArrayList<Integer> matchedResultList = new ArrayList<>();
        int numOfLotto = issuedLottoList.size();
        for (int i = 0; i < numOfLotto; i++) {
            int matchedNumber = getMatchedNumber(issuedLottoList.get(i), winningLottoNumberList);
            matchedResultList.add(matchedNumber);
        }
        return matchedResultList;
    }

    public int getMatchedNumber(ArrayList<Integer> issuedLotto, ArrayList<Integer> winningLottoNumberList) {
        issuedLotto.retainAll(winningLottoNumberList);
        return issuedLotto.size();
    }
}
