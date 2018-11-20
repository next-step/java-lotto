package lotto.config;

import lotto.dao.LottosGenerator;
import lotto.dto.Lotto;
import lotto.dto.Money;
import lotto.utils.LottoMaker;

import java.util.ArrayList;
import java.util.List;

public class ManualLottoGeneratorImpl implements LottosGenerator {

    private String ManualInputs;

    public ManualLottoGeneratorImpl(String manualInputs) {
        ManualInputs = manualInputs;
    }

    @Override
    public List<Lotto> genertate(Money money) {
        List<Lotto> lottos = new ArrayList<>();
        for(String stringLotto : LottoMaker.ofNewLine2(ManualInputs)){
            lottos.add(LottoMaker.of(stringLotto));
        }
        return lottos;
    }
}
