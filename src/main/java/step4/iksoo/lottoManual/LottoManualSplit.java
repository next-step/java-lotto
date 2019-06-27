package step4.iksoo.lottoManual;

import java.util.ArrayList;
import java.util.List;

public class LottoManualSplit {
    private List<LottoNo> LottoNumbers;

    LottoManualSplit(String LottoNumbers) {
        this.LottoNumbers = convertToList(makeLotto(LottoNumbers));
    }

    private String[] makeLotto(String LottoNumbers) {
        if (LottoNumbers == null || LottoNumbers.isEmpty() || isNotLottoNumber(LottoNumbers)) {
            throw new IllegalArgumentException("1~45 사이의 값을 입력해주세요.");
        }
        return LottoNumbers.replace(" ", "").split(",|:");
    }

    private boolean isNotLottoNumber(String LottoNumbers) {
        String[] tokens = LottoNumbers.replace(" ", "").split(",|:");
        boolean isNormal = false;
        for (int i = 0; i < tokens.length; i++) {
            isNormal = isNormal || (Integer.parseInt(tokens[i]) < 0 || Integer.parseInt(tokens[i]) > 45) ? true : false;
        }
        return isNormal;
    }

    private List<LottoNo> convertToList(String[] LottoNumbers) {
        List<LottoNo> lotto = new ArrayList<>();
        for (int i = 0; i < LottoNumbers.length; i++) {
            lotto.add(new LottoNo(Integer.parseInt(LottoNumbers[i])));
        }
        return lotto;
    }

    public List<LottoNo> getLottoNumbers() {
        return this.LottoNumbers;
    }
}
