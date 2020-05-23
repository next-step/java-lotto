package lotto.domain.fake;

import lotto.domain.AutoLottoNumberGenerator;

import java.util.List;

public class FakeAutoLottoNumberGenerator extends AutoLottoNumberGenerator {
    private List<Integer> fakeLottoNumbers;

    public FakeAutoLottoNumberGenerator(List<Integer> fakeLottoNumbers) {
        this.fakeLottoNumbers = fakeLottoNumbers;
    }

    @Override
    public List<Integer> generateLottoNumber(List<Integer> lottoNumbers, int lottoCount) {
        return fakeLottoNumbers;
    }
}
