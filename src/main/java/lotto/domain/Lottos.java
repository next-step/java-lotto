package lotto.domain;

import java.util.*;

public class Lottos implements Iterable<Lotto>{
    private List<Lotto> lottoGames = new ArrayList<>();


    public Lottos(LottoNumberFactory factory, int money) {
        int lottoCount = money / Lotto.PRICE;
        for (int i = 0; i < lottoCount; i++) {
            lottoGames.add(createLotto(factory,Collections.EMPTY_LIST));
        }
    }

    public Lottos(LottoNumberFactory factory, List<List<Integer>> lottoGames) {
        for( List<Integer> lotto  : lottoGames) {
            this.lottoGames.add(createLotto(factory,lotto));
        }
    }
    public static Lotto createLotto(LottoNumberFactory factory, List<Integer> numbers) {
        Set<LottoNumber> lotto = new HashSet<>();
        for( int i = 0; i < numbers.size(); i++) {
            Number lottoNumber = createLottoNumber(factory,numbers.get(i));
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
        for (Lotto game : lottoGames) {
            ranks.add(winGame.matchCount(game));
        }
        return new LottoStatics(ranks);
    }

    public int size() {
        return lottoGames.size();
    }

    @Override
    public Iterator<Lotto> iterator() {
        return lottoGames.iterator();
    }
}
