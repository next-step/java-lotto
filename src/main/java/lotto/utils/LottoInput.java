package lotto.utils;

import java.util.List;

public class LottoInput implements LottoType {

    private List lottoNumbers;

    public LottoInput(List inputNubers) {
        this.lottoNumbers = inputNubers;
    }

    @Override
    public List makeLottoNumber() {
        return this.lottoNumbers;
    }
}
