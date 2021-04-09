package lotto.domain;

import lotto.util.Constant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lotto {
    List<Integer> lottoNumber;

    public Lotto(List<Integer> lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public Lotto() {
        this.lottoNumber = initLottoNumber();
    }

    public List<Integer> getLottoNumber() {
        return lottoNumber;
    }

    private List<Integer> initLottoNumber() {
        List<Integer> list = new ArrayList<>();
        for (int i = Constant.LOTTO_RANGE_START; i <= Constant.LOTTO_RANGE_END; i++) {
            list.add(i);
        }
        return list;
    }

    // 로또 갯수 만큼 사기.
    public Lotto buyLotto() {
        return new Lotto(this.draw());
    }

    private List<Integer> draw() {
        List<Integer> list = new ArrayList<>();
        Collections.shuffle(lottoNumber);
        for (int i = 0; i < Constant.LOTTO_COUNT; i++) {
            list.add(lottoNumber.get(i));
        }
        Collections.sort(list);
        return list;
    }

    public int lottoSize(){
        return lottoNumber.size();
    }

    public String displayLottoNumber() {
        return Arrays.toString(lottoNumber.toArray());
    }

    public WinningCount winningLottoCount(Lotto lotto, int bonusNumber) {
        WinningCount winningCount = new WinningCount();
        List<Integer> lottoNumber = lotto.getLottoNumber();
        for (Integer number: lottoNumber){
            plusWinningCount(winningCount, number, bonusNumber);
        }

        return winningCount;
    }

    public void plusWinningCount(WinningCount winningCount, Integer number, int bonusNumber){
        if(lottoNumber.contains(number)){
            winningCount.plus(number == bonusNumber);
        }
    }
}
