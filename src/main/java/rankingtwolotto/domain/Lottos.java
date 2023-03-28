package rankingtwolotto.domain;

import rankingtwolotto.rankingexception.ExceptionCommand;
import rankingtwolotto.rankingexception.RankingValueException;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        validateLottos(lottos);
        this.lottos = lottos;
    }

    private void validateLottos(List<Lotto> lottos) {
        if (lottos.isEmpty() || lottos == null) {
            throw new RankingValueException(ExceptionCommand.INPUT_EXCEPTION_MESSAGE);
        }
    }

    public static Lottos createLottos(int purchaseLottoNum) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < purchaseLottoNum; i++) {
            lottos.add(createRandomLotto());
        }
        return new Lottos(lottos);
    }

    private static Lotto createRandomLotto() {
        Lotto randomLotto;
        try{
            randomLotto = new Lotto(Lotto.getRandomLotto());
        }
        catch (RankingValueException e){
            randomLotto = new Lotto(Lotto.getRandomLotto());
        }
        return randomLotto;
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

}
