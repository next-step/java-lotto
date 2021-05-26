package lotto.domain;

import java.util.*;

public class Lottos implements Iterable<Lotto>{
    private List<Lotto> lottos = new ArrayList<>();


    public Lottos(LottoNumberFactory factory, int money) {
        int lottoCount = money / Lotto.PRICE;
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(createLotto(factory,Collections.emptyList()));
        }
    }

    public Lottos(LottoNumberFactory factory, List<List<Integer>> lottos) {
        for( List<Integer> lotto  : lottos) {
            this.lottos.add(createLotto(factory,lotto));
        }
    }
    public static Lotto createLotto(LottoNumberFactory factory, List<Integer> numbers) {
        Set<LottoNumber> lotto = new HashSet<>();
        for( Integer number : numbers) {
            Number lottoNumber = createLottoNumber(factory,number);
            lotto.add(new LottoNumber(lottoNumber));
        }

        while(lotto.size() < Lotto.NUMBER_COUNT) {
            lotto.add(new LottoNumber(createLottoNumber(factory,null)));
        }
        return new Lotto(lotto);
    }

    private static Number createLottoNumber(LottoNumberFactory factory,Integer number) {
        return factory.generateNumber(number);
    }

    public LottoStatics calculateStatics(Lotto winGame) {
        List<Rank> ranks = new ArrayList<>();
        for (Lotto game : lottos) {
            ranks.add(winGame.matchCount(game));
        }
        return new LottoStatics(ranks);
    }

    public int size() {
        return lottos.size();
    }

    @Override
    public Iterator<Lotto> iterator() {
        return lottos.iterator();
    }
}
