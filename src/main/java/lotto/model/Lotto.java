package lotto.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lotto {

    public final static String LOTTO_TYPE_AUTO = "auto";
    public final static String LOTTO_TYPE_MANUAL = "manual";

    private Map<String, LottoNumbers> userlottoNumbers  = new HashMap<>();

    public Lotto(int lottoAutoCount, List<String> manualNumbers) {

        List<LottoNumber> lottoMaunalNumbers = new ArrayList<>();
        for (String manualNumber : manualNumbers) {
            lottoMaunalNumbers.add(new LottoNumber(LottoNumberGenerator.makeManualNumber(manualNumber)));
        }
        List<LottoNumber> lottoAutoNumbers = new ArrayList<>();
        for (int i = 0; i < lottoAutoCount; i++) {
            lottoAutoNumbers.add(new LottoNumber(LottoNumberGenerator.makeAutoNumber()));
        }

        userlottoNumbers.put(LOTTO_TYPE_MANUAL, new LottoNumbers(lottoMaunalNumbers));
        userlottoNumbers.put(LOTTO_TYPE_AUTO, new LottoNumbers(lottoAutoNumbers));
    }

    public LottoNumbers getAutoLottoNumbers() {
        return this.userlottoNumbers.get(LOTTO_TYPE_AUTO);
    }

    public LottoNumbers getManualLottoNumbers() {
        return this.userlottoNumbers.get(LOTTO_TYPE_MANUAL);
    }

    public List<RewardStatus> getManualRewardLotto(String[] winningNumber, int bonus) {
        return userlottoNumbers.get(LOTTO_TYPE_MANUAL)
                .getLottoNumbersRewardStatus(winningNumber, bonus);
    }

    public List<RewardStatus> getAutoRewardLotto(String[] winningNumber, int bonus) {
        return userlottoNumbers.get(LOTTO_TYPE_AUTO)
                .getLottoNumbersRewardStatus(winningNumber, bonus);
    }

    public int getManualLotto() {
        return userlottoNumbers.get(LOTTO_TYPE_MANUAL).getLottoCount();
    }

    public int getAutoLotto() {
        return userlottoNumbers.get(LOTTO_TYPE_AUTO).getLottoCount();
    }

}
