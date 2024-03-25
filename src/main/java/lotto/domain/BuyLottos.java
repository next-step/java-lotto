package lotto.domain;

import lotto.interf.LottoStrategy;
import lotto.interf.RandomLottoStrategy;
import lotto.utils.RandomGenerator;

import java.util.ArrayList;
import java.util.List;

public class BuyLottos {
    private Price price;
    private List<Lotto> lottos;


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
            List<Integer> randomList = genRandomLottoList(genLotto());
            Lotto lotto = new Lotto(randomList);
            this.lottos.add(lotto);
        }
    }

    private List<Integer> genRandomLottoList(LottoStrategy LottoStrategy){
        return LottoStrategy.genLotto();
    }

    private static LottoStrategy genLotto(){
        RandomGenerator randomGenerator = new RandomGenerator();
        return new RandomLottoStrategy(randomGenerator);
    }
}
