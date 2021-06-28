package lottogame.model;


import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private List<Lotto> lottos = new ArrayList<>();
    private LottoMachine lottoMachine = new LottoMachine();

    public void purchaseAutoLottoList(int buyCount) {
        for (int i = 0; i < buyCount; i++) {
            lottos.add(lottoMachine.generateAutoLotto());
        }
    }

    public void purchaseManualLottoList(List<String> manualLottoList) {
        for (String manualLottoStr : manualLottoList) {
            lottos.add(lottoMachine.generateLotto(manualLottoStr));
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public WinningStatistics getWinning(WinningLottoNumbers winningNumbers) {
        List<Rank> lottoRankList = new ArrayList<>();

        for (Lotto lotto : lottos) {
            int numberOfWinnings = getNumberOfWinnings(lotto, winningNumbers.getWinningLottoNumbers());
            boolean bonus = isBonus(lotto, winningNumbers.getBonusNumber());
            Rank rank = Rank.getRank(numberOfWinnings, bonus);
            lottoRankList.add(rank);
        }

        return new WinningStatistics(lottoRankList, lottos.size());
    }

    public int getNumberOfWinnings(Lotto lotto, Lotto winningLotto) {
        return (int) lotto.getNumbers().stream()
                .filter(lottoNumber -> winningLotto.containsNumber(lottoNumber))
                .count();
    }

    public boolean isBonus(Lotto lotto, LottoNumber bonusNumber) {
        return lotto.containsNumber(bonusNumber);
    }
}
