package lotto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    public final static String LOTTO_TYPE_AUTO = "auto";
    public final static String LOTTO_TYPE_MANUAL = "manual";

    private List<LottoNumber> lottoNumbers = new ArrayList<>();

    public Lotto(int lottoAutoCount, List<String> manualNumbers) {
        for (String manualNumber : manualNumbers) {
            this.lottoNumbers.add(new LottoNumber(LottoNumberGenerator.getManualNumber(manualNumber), LOTTO_TYPE_MANUAL));
        }
        for (int i = 0; i < lottoAutoCount; i++) {
            this.lottoNumbers.add(new LottoNumber(LottoNumberGenerator.getAutoNumber(), LOTTO_TYPE_AUTO));
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

    public int getManualLotto() {
        return (int) lottoNumbers.stream()
                            .filter(lottoNumber -> lottoNumber.getIssueType() == LOTTO_TYPE_MANUAL)
                            .count();
    }

    public int getAutoLotto() {
        return (int) lottoNumbers.stream()
                .filter(lottoNumber -> lottoNumber.getIssueType() == LOTTO_TYPE_AUTO)
                .count();
    }

}
