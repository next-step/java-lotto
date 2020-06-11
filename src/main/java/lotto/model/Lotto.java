package lotto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private List<LottoNumber> lottoNumbers = new ArrayList<>();

    public Lotto(int lottoCount) {
        for (int i = 0; i < lottoCount; i++) {
            this.lottoNumbers.add(new LottoNumber(LottoNumberGenerator.getNumber()));
        }
    }

    public List<LottoNumber> getLottoNumbers() {
        return this.lottoNumbers;
    }

    public List<RewardStatus> getRewardLotto(String[] winningNumber, int bonus) {
        return lottoNumbers.stream()
                        .map(lottoNumber -> lottoNumber.getRewardStatus(winningNumber, bonus))
                        .collect(Collectors.toList());
    }

}
