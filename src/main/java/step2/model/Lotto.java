package step2.model;

import step2.util.StringUtil;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

    private final List<List<Integer>> lottos = new ArrayList<>();
    private final PrizeStatics prizeStatics = new PrizeStatics();

    //로또 추가
    public void addLotto(List<Integer> lotto) {
        this.lottos.add(lotto);
    }

    public List<List<Integer>> getLottos() {
        return lottos;
    }

    //당첨번호를 받아 로또 당첨 개수를 확인
    public void checkPrizeNum(String prizeNum) {
        String[] prizeLotto = StringUtil.divideNum(prizeNum);

        for (List<Integer> lotto : lottos) {
            int matchCount = checkLottoNum(lotto, prizeLotto);
            prizeStatics.prize(matchCount);
        }
    }

    public PrizeStatics getPrizeStatics() {
        return prizeStatics;
    }

    //로또의 동일 숫자 확인
    private int checkLottoNum(List<Integer> lotto, String[] prizeLotto) {
        int matchCount = 0;
        for (String s : prizeLotto) {
            if (lotto.contains(Integer.parseInt(s))) {
                matchCount++;
            }
        }
        return matchCount;
    }
}
