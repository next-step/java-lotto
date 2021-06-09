package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoList {

    private List<Lotto> lottoList = new ArrayList<>();
    private LottoMachine lottoMachine;

    public LottoList(int buyCount) {
        lottoMachine = new LottoMachine();
        for (int i = 0; i < buyCount; i++) {
            lottoList.add(lottoMachine.getAutoLotto());
        }
    }

    public WinningStatistics getWinning(WinningLottoNumbers winningNumbers) {
        List<Rank> list = new ArrayList<>();
        for (Lotto lotto : lottoList) {
            int numberOfWinnings = 0;
            numberOfWinnings = getNumberOfWinnings(lotto, numberOfWinnings, winningNumbers.getWinningLottoNumbers());
            boolean bonus = false;
            bonus = isBonus(lotto, bonus, winningNumbers.getBonusNumber());
            Rank rank = Rank.getRank(numberOfWinnings, bonus);
            list.add(rank);
        }

        return new WinningStatistics(list.stream().collect(Collectors.groupingBy(x -> x, Collectors.counting())));
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

    public void getManualLotto(String manualLottoStr) {
        lottoList.add(lottoMachine.getManualLotto(manualLottoStr));
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }
}
