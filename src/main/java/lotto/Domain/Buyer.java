package lotto.Domain;


import java.util.ArrayList;
import java.util.List;

public class Buyer {

    LottoMachine lottoMachine;

    private Buyer() {
        this.lottoMachine = LottoMachine.init();
    }

    public static Buyer of() {
        return new Buyer();
    }


    public int payToLotto(int amount) {
        return lottoMachine.boughtLottoCount(amount);
    }

    public Lottos purchaseAutoLotto(int lottoCount) {
        Lottos lottos = Lottos.init(new ArrayList<>());
        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = lottoMachine.buyLotto(lottoMachine.makeAutoTargetNumber());
            lottos.add(lotto);
        }
        return lottos;
    }

    public WinningLotto winningLottoNumbers(List<Integer> lottoNumbers, int bonus) {
        Lotto winningLotto = Lotto.init(lottoNumbers);
        return WinningLotto.init(winningLotto, bonus);
    }

    public LottoResult lottoResult(Lottos lottos, WinningLotto winningLotto) {
        return lottos.match(winningLotto);
    }
}