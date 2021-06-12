package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoList {

    private List<Lotto> lottoList = new ArrayList<>();
    private LottoMachine lottoMachine;

    public LottoList(int buyCount) {
        lottoMachine = new LottoMachine();
        for (int i = 0; i < buyCount; i++) {
            lottoList.add(lottoMachine.generateAutoLotto());
        }
    }

    public WinningStatistics getWinning(WinningLottoNumbers winningNumbers) {
        List<Rank> lottoRankList = new ArrayList<>();
        for (Lotto lotto : lottoList) {
            int numberOfWinnings = 0;
            numberOfWinnings = getNumberOfWinnings(lotto, numberOfWinnings, winningNumbers.getWinningLottoNumbers());
            boolean bonus = false;
            bonus = isBonus(lotto, bonus, winningNumbers.getBonusNumber());
            Rank rank = Rank.getRank(numberOfWinnings, bonus);
            lottoRankList.add(rank);
        }

        return new WinningStatistics(lottoRankList);
    }

    private boolean isBonus(Lotto lotto, boolean bonus, int bonusNumber) {
        if (lotto.getLottoNumbers().contains(bonusNumber)) {
            bonus = true;
        }
        return bonus;
    }

    private int getNumberOfWinnings(Lotto lotto, int numberOfWinnings, Lotto winningLotto) {
        for (int lottoNumber : lotto.getLottoNumbers()) {
            if (winningLotto.getLottoNumbers().contains(lottoNumber)) {
                numberOfWinnings++;
            }
        }
        return numberOfWinnings;
    }

    public void resolveManualLottoList(List<String> manualLottoList) {
        for (String manualLottoStr : manualLottoList) {
            lottoList.add(lottoMachine.getManualLotto(manualLottoStr));
        }
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }
}
