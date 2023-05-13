package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Customer {
    private Money money;
    private Money lottoMoney;
    private Lottos autoLottos;
    private Lottos manualLottos;
    private Map<KLottoRank, Integer> rank = new HashMap<>();

    public Customer(int money) {
        this.money = new Money(money);
        this.lottoMoney = new Money(0);
        this.autoLottos = new Lottos();
        this.manualLottos = new Lottos();
    }

    public void buyAutoLotto() {

        if (money.getMoney() < Lotto.LOTTO_PRICE) {
            throw new IllegalStateException("로또 살 돈이 부족합니다.");
        }

        int lottoCount = money.getMoney() / Lotto.LOTTO_PRICE;
        lottoMoney = lottoMoney.buyLotto(lottoCount * Lotto.LOTTO_PRICE);
        money = money.spend(lottoCount * Lotto.LOTTO_PRICE);
        for (int i = 0; i < lottoCount; i++) {
            autoLottos.add(new Lotto());
        }
    }

    public void buyManualLotto(int count, List<List<Integer>> manualLottoNumbers) {
        validateManualLotto(count, manualLottoNumbers);

        lottoMoney = lottoMoney.buyLotto(count * Lotto.LOTTO_PRICE);
        money = money.spend(count * Lotto.LOTTO_PRICE);

        for (List<Integer> manualLottoNumber : manualLottoNumbers) {
            manualLottos.add(new Lotto(manualLottoNumber));
        }
    }

    private void validateManualLotto(int count, List<List<Integer>> manualLottoNumbers) {
        if(money.getMoney() < Lotto.LOTTO_PRICE * count){
            throw new IllegalStateException("로또 살 돈이 부족합니다.");
        }

        if(count != manualLottoNumbers.size()){
            throw new IllegalArgumentException("수동 인자가 맞지 않습니다.");
        }
    }

    public Map<KLottoRank, Integer> checkLottoWin(WinNumber winNumber) {
        Map<KLottoRank, Integer> autoRank = autoLottos.checkWin(winNumber);
        Map<KLottoRank, Integer> manualRank = manualLottos.checkWin(winNumber);
        combineRanks(autoRank, manualRank);
        return rank;
    }

    private void combineRanks(Map<KLottoRank, Integer> autoRank, Map<KLottoRank, Integer> manualRank){
        rank.putAll(autoRank);
        manualRank.forEach((key, value) -> rank.merge(key, value, Integer::sum));
    }

    public int getLottoMoney() {
        return this.lottoMoney.getMoney();
    }

    public int getMoney() {
        return this.money.getMoney();
    }

    public List<Lotto> getAutoLottos() {
        return this.autoLottos.getLottos();
    }

    public List<Lotto> getManualLottos(){
        return this.manualLottos.getLottos();
    }
}
