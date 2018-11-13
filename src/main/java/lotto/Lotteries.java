package lotto;

import java.util.ArrayList;
import java.util.List;

//로또 카운트 만큼 생성하기
public class Lotteries {

    private List<Lotto> lotteries;
    private int lottoNum;

    public Lotteries(int lottoNum){
        this.lottoNum = lottoNum;
        this.lotteries = new ArrayList<Lotto>();
    }

    public List<Lotto> buyLotto(){
        for(int i = 0; i < lottoNum; i++){
            Lotto lotto = new Lotto();
            lotto.generateLottoNumber();
            this.lotteries.add(lotto);
        }
        return lotteries;
    }

}
