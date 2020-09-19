package lotto.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class LottoStore {
    private LottoStore(){}

    public static Lottos sold(BigDecimal price, String[] manualLottoStrArr){
        Lottos lottos = new Lottos();
        int amount = price.divide(Lotto.PRICE).intValue();
        int autoLottoAmount = amount - manualLottoStrArr.length;

        List<Lotto> manualLottos = makeManualLotto(manualLottoStrArr);
        List<Lotto> autoLottos  = makeAutoLotto(autoLottoAmount);

        lottos.addAll(manualLottos);
        lottos.addAll(autoLottos);

        return lottos;
    }

    private static List<Lotto> makeManualLotto(String[] manualLottoStrArr){
        List<Lotto> lottos = new ArrayList<>();
        for(String manualLottoStr : manualLottoStrArr){
            lottos.add(new Lotto(manualLottoStr));
        }

        return lottos;
    }

    private static List<Lotto> makeAutoLotto(int amount){
        List<Lotto> lottos = new ArrayList<>();
        for(int i = 0 ; i < amount ; i ++){
            lottos.add(LottoFactory.create());
        }

        return lottos;
    }

    public static Winners getWinner(Lottos lottos, String[] winningNumbers, int bonumsNumber){
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonumsNumber);
        return lottos.getWinner(winningLotto);
    }
}