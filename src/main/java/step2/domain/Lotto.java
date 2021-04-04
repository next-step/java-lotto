package step2.domain;

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
        for (Integer i = 1; i < 46; i++) {
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
        for (int i = 0; i < 6; i++) {
            list.add(lottoNumber.get(i));
        }
        Collections.sort(list);
        return list;
    }

    public int lottoSize(){
        return lottoNumber.size();
    }

    public int numberConfirm(Integer number){
        return lottoNumber.contains(number) ? 1 : 0 ;
    }


    public String displayLottoNumber() {
        return Arrays.toString(lottoNumber.toArray());
    }
}
