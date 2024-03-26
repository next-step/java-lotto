package lotto.domain;

import lotto.interf.LottoStrategy;
import lotto.interf.RandomLottoStrategy;
import lotto.utils.RandomGenerator;
import lotto.utils.StringToListConverter;

import java.util.ArrayList;
import java.util.List;

public class BuyLottos {
    private Price price;
    private List<Lotto> lottos;


    public BuyLottos(int price) {
        this.price = new Price(price);
        this.lottos = new ArrayList<>();
    }

    public BuyLottos(int price, List<String> manual){
        this.price = new Price(price);
        this.lottos = new ArrayList<>();

        for(String str: manual){
            List<Integer> manualLottoList = StringToListConverter.toList(str);
            Lotto manualLotto = new Lotto(manualLottoList);
            this.lottos.add(manualLotto);
        }
    }

    public BuyLottos(List<Lotto> lottos, int price) {
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
        int numOfAuto = numOfLotto - this.lottos.size();

        for (int i = 0 ; i< numOfAuto; i++) {
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
