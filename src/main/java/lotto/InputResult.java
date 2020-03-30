package lotto;

import java.util.ArrayList;
import java.util.List;

public class InputResult {
    private static int LOTTO_PRICE;
    private final int lottoCount;
    private List<LottoNumbers> generatedLottos;

    public InputResult(int lottoCount, List<LottoNumbers> generatedLottos) {
        this.lottoCount = lottoCount;
        this.generatedLottos = new ArrayList<>(generatedLottos);
    }

    public String showResult(int lottoCount, List<LottoNumbers> generatedLottos) {
        StringBuilder sb = new StringBuilder();
        sb.append(lottoCount * LOTTO_PRICE);
        sb.append(System.getProperty("line.separator"));
        sb.append(lottoCount + "개를 구매했습니다.");

        for (int i = 0; i < generatedLottos.size(); i++) {

        }

        return sb.toString();
    }


}
