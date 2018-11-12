package lotto;

import java.util.ArrayList;
import java.util.List;

//로또 카운트 만큼 생성하기
public class Lotteries {

    private List<List<Integer>> lotteries;
    private int lottoNum;

    public Lotteries(int lottoNum){
        this.lottoNum = lottoNum;
       // this.lotto = new Lotto();
        this.lotteries = new ArrayList();
    }

    public List<List<Integer>> buyLotto(){
        Lotto pn = new Lotto();
        for(int i=0;i<lottoNum;i++){
            this.lotteries.add(pn.generateLottoNumber());
        }
        return lotteries;
    }

}
