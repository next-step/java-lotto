package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoNumbers {

    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers(int count) {
        this.lottoNumbers = createLottoNumbers(count);
    }

    private List<LottoNumber> createLottoNumbers(int count) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            lottoNumbers.add(new LottoNumber());
        }
        return lottoNumbers;
    }

    public List<LottoRank> getRanks(LottoNumber winningNumber) {
        List<LottoRank> lottoRanks = new ArrayList<>();

        for (LottoNumber each : lottoNumbers) {
            lottoRanks.add(each.getRank(winningNumber));
        }

        return lottoRanks;
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    public int size() {
        return lottoNumbers.size();
    }
}
