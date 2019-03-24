package domain;

import java.util.*;

public class LottoGame {

    private List<Lotto> userLottos;
    private Map<Integer, Integer> profit = new HashMap<>();


    public LottoGame(int lottoCount) {
        userLottos = new ArrayList<Lotto>(lottoCount);

        for (int i = 0 ; i < lottoCount ; i++) {
            userLottos.add(new Lotto());
        }
    }

    public Map<Integer, Integer> getMultipleResults(WinningLotto winningLotto) {

        Map<Integer, Integer> totalResults = new HashMap<>();
        totalResults.put(3,0);
        totalResults.put(4,0);
        totalResults.put(5,0);
        totalResults.put(6,0);

        for(Lotto userLotto : userLottos) {
            LottoResult result = new LottoResult(winningLotto, userLotto);
            int numberOfMatch = result.getNumberOfMatch();
            if(numberOfMatch >= 3) {
                totalResults.put(numberOfMatch, totalResults.get(numberOfMatch) + 1);
            }
        }
        System.out.println(totalResults.toString());
        return totalResults;
    }

    public void printUserLottos() {
        System.out.println(userLottos.toString());
    }


}
