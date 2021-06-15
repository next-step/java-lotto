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
            int numberOfWinnings = getNumberOfWinnings(lotto, winningNumbers.getWinningLottoNumbers());
            boolean bonus = isBonus(lotto, winningNumbers.getBonusNumber());
            Rank rank = Rank.getRank(numberOfWinnings, bonus);
            lottoRankList.add(rank);
        }

        return new WinningStatistics(lottoRankList);
    }

    private boolean isBonus(Lotto lotto, int bonusNumber) {
        return lotto.getLottoNumbers().contains(bonusNumber);
    }

    private int getNumberOfWinnings(Lotto lotto, Lotto winningLotto) {
        return (int) lotto.getLottoNumbers().stream()
                .filter(lottoNumber -> winningLotto.getLottoNumbers().contains(lottoNumber))
                .count();
    }

    public void resolveManualLottoList(List<String> manualLottoList) {
        for (String manualLottoStr : manualLottoList) {
            lottoList.add(lottoMachine.generateManualLotto(manualLottoStr));
        }
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }
}
