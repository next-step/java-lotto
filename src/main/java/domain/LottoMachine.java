package domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoMachine {
    public static final Integer LOTTO_PRICE = 1000;

    private WinningLotto winningLotto;

    public void initWinningLotto(WinningLotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public LottoResult createLottoResult(List<Lotto> lottos){
        if(winningLotto == null) {
            throw new IllegalStateException();
        }

        return lottos.stream()
            .map(winningLotto::matchLotto)
            .collect(Collectors.collectingAndThen(Collectors.toList(), LottoResult::new));
    }
}
