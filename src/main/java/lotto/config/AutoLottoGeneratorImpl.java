package lotto.config;

import lotto.dao.LottosGenerator;
import lotto.dto.Lotto;
import lotto.dto.Money;
import lotto.utils.LottoMaker;

import java.util.ArrayList;
import java.util.List;

public class AutoLottoGeneratorImpl implements LottosGenerator {

    @Override
    public List<Lotto> genertate(Money money) {
        List<Lotto> lottos = new ArrayList<>();
        for(int i = 0 ; i < money.getNumOfGames() ; i++ ){
            lottos.add(LottoMaker.lottoOf());
        }

        return lottos;
    }
}
