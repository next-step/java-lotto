package lotto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {

    List<LottoNumber> lottoNumbers = new ArrayList<>();

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    public int getLottoCount() {
        return (int) lottoNumbers.stream().count();
    }

    public List<RewardStatus> getLottoNumbersRewardStatus(String[] winningNumber, int bonus) {
        return lottoNumbers.stream()
                .map(lottoNumber -> lottoNumber.getRewardStatus(winningNumber, bonus))
                .collect(Collectors.toList());
    }
}
