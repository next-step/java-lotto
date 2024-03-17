package lotto;

import java.util.ArrayList;
import java.util.List;

public class BuyLottos {
    private Price price;
    private List<Lotto> lottos;
    private static final int LOTTO_ELEMENT_NUM = 6;


    public BuyLottos(int price) {
        this.price = new Price(price);
        this.lottos = new ArrayList<>();
    }

    public BuyLottos(int price, List<Lotto> lottos) {
        this.price = new Price(price);
        this.lottos = lottos;
    }

    public int getCountOfLotto() {
        return this.price.price/1000;
    }

    public List<Lotto> getLottos(){
        return this.lottos;
    }

    public void buyLottos(){
        int numOfLotto = getCountOfLotto();
        for (int i = 0 ; i< numOfLotto; i++) {
            Lotto lotto = new Lotto();
            lotto.oneLotto();
            this.lottos.add(lotto);
        }
    }

}
