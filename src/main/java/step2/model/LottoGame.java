package step2.model;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import java.util.stream.Stream;
import step2.exception.LottoOutOfSelfLottoException;
import step2.util.LottoMakeNumbers;

public class LottoGame {

    private Lottos lottos;

    private int lottoSelfCount;

    private LottoMoney lottoMoney;

    public LottoGame(LottoMoney lottoMoney, Lottos lottosSelf) {
        this.lottoMoney = lottoMoney;
        this.lottoSelfCount = lottosSelf.getCount();

        validateLottoGame();

        this.lottos = createRandomLotto(lottosSelf);
    }

    private Lottos createRandomLotto(Lottos lottosSelf) {
        Lottos lottos = Stream.generate(LottoMakeNumbers::getRandomNumber)
            .limit(getLottoRandomCount())
            .collect(collectingAndThen(toList(), Lottos::of));

        lottos.addLottos(lottosSelf);
        return lottos;
    }

    public int getLottoRandomCount() {
        return lottoMoney.getLottoCount() - lottoSelfCount;
    }

    public int getLottoSelfCount() {
        return lottoSelfCount;
    }

    public Lottos getLottos() {
        return lottos;
    }

    private void validateLottoGame() {
        if (lottoMoney.getLottoCount() < lottoSelfCount) {
            throw new LottoOutOfSelfLottoException();
        }
    }
}