package step3.param;

import java.util.List;

public class ManualLottoNumbersParam {
    List<ManualLottoNumberParam> lottoNumbers;

    public ManualLottoNumbersParam(List<ManualLottoNumberParam> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static ManualLottoNumbersParam from(List<ManualLottoNumberParam> lottoNumbers) {
        return new ManualLottoNumbersParam(lottoNumbers);
    }
    public List<ManualLottoNumberParam> getLottoNumbers() {
        return lottoNumbers;
    }
}
