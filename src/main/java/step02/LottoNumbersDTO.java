package step02;

import java.util.Set;

import static step02.LottoConfig.*;
import static step02.LottoConfig.BLANK;

public class LottoNumbersDTO {
    private Set<LottoNumber> lottoNumbers;

    public void setLottoNumbers(Set<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public String getLottoNumbersToString() {
        StringBuilder stringBuilder = new StringBuilder();
        int index = ZERO;

        for (LottoNumber lottoNumber : lottoNumbers) {
            stringBuilder.append(lottoNumber.getLottoNumber());
            addSeparate(index, stringBuilder);
            index++;
        }
        return stringBuilder.toString();
    }

    private void addSeparate(int index, StringBuilder stringBuilder) {
        if (index < lottoNumbers.size() - ONE) {
            stringBuilder.append(REGEX + BLANK);
        }
    }
}
