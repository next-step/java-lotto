package domain;

import exception.InvalidBonusNumberException;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos){
        Objects.requireNonNull(lottos);
        this.lottos = lottos;
    }

    public LottoResult calculate(Lotto winningLotto, int bonusNumber) throws InvalidBonusNumberException {
        if(winningLotto.hasBonus(bonusNumber)) {
            throw new InvalidBonusNumberException();
        }

        LottoResult lottoResult = new LottoResult();

        lottos.forEach(lotto -> lottoResult.addPrizeResult(lotto.checkWhetherToWin(winningLotto, bonusNumber)));

        return lottoResult;
    }

    public Stream stream(){
        return lottos.stream();
    }

    public int size() {
        return lottos.size();
    }
}
