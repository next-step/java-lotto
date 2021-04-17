package step02.dto;

import step02.model.lotto.LottoNumber;

import java.util.*;

import static step02.utils.LottoConfig.*;

public class LottoNumbersDTO {
    private List<LottoNumber> lottoNumbers;

    public void setLottoNumbers(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public String getLottoNumbersToString() {
        StringBuilder stringBuilder = new StringBuilder();
        final int[] index = {ZERO};

        lottoNumbers.stream().sorted(Comparator.comparing(LottoNumber::getLottoNumber))
                .forEach(lottoNumber -> {
                    stringBuilder.append(lottoNumber.getLottoNumber());
                    addSeparate(index[0], stringBuilder);
                    index[0]++;
                });

        return stringBuilder.toString();
    }

    private void addSeparate(int index, StringBuilder stringBuilder) {
        if (index < lottoNumbers.size() - ONE) {
            stringBuilder.append(REGEX + BLANK);
        }
    }
}
