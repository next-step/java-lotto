package lotto.domain;

public class LottoGame {

    final static int PRICE = 1000;

    public int getBuyCount(int buyPrice){
        return buyPrice/PRICE;
    }

    public LottoAuto getLotto(){
        return new LottoAuto();
    }

    public Lottos getLottos(int buyCount) {
        Lottos lottos = new Lottos();
        for(int i =0; i<buyCount; i ++){
            lottos.add(getLotto());
        }
        return lottos;
    }
}
