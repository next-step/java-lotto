package step2.model;

import step2.exception.LottoOutOfSelfLottoException;
import step2.util.LottoMakeNumbers;

import java.util.stream.Stream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class LottoGame {
    private Lottos lottos;
    private Lottos lottosSelf;
    private LottoMoney lottoMoney;

    public LottoGame(LottoMoney lottoMoney, Lottos lottosSelf) {
        this.lottoMoney = lottoMoney;
        this.lottosSelf = lottosSelf;

        validateLottoGame();

        this.lottos = createRandomLotto();
    }

    private Lottos createRandomLotto() {
        Lottos lottos = Stream.generate(LottoMakeNumbers::getRandomNumber)
                .limit(getLottoRandomCount())
                .collect(collectingAndThen(toList(), Lottos::of));

        lottos.addLottos(lottosSelf);
        return lottos;
    }

    public int getLottoRandomCount() {
        return lottoMoney.getLottoCount() - lottosSelf.getCount();
    }

    public int getLottoSelfCount() {
        return lottosSelf.getCount();
    }

    public Lottos getLottos() {
        return lottos;
    }

    private void validateLottoGame() {
        if(lottoMoney.getLottoCount() < lottosSelf.getCount()) {
            throw new LottoOutOfSelfLottoException();
        }
    }
}