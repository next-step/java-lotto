package lotto;

import java.util.ArrayList;
import java.util.List;

public class InputResult {
    private final int lottoCount;
    private List<LottoNumbers> generatedLottos;

    public InputResult(Lotto lotto) {
        this.lottoCount = lotto.getLottoCount();
        this.generatedLottos = new ArrayList<>(lotto.generateLottos());
    }

    public String showResult() {
        StringBuilder sb = new StringBuilder();
        sb.append(System.getProperty("line.separator"));
        sb.append(this.lottoCount + "개를 구매했습니다.");
        sb.append(System.getProperty("line.separator"));

        for (LottoNumbers lottoNumbers: this.generatedLottos) {
            sb.append(lottoNumbers.getLottoNumbers().toString());
            sb.append(System.getProperty("line.separator"));
        }

        return sb.toString();
    }


}
