package domain.generator;

import domain.Lotto;
import domain.LottoNumbers;
import domain.LottosGenerator;
import util.Generator;

public class AutoLotto implements LottosGenerator {

    @Override
    public Lotto generate() {
        return new Lotto(LottoNumbers.convertToLottoNo(Generator.lottoNumbers()));
    }
}
