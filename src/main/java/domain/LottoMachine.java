package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoMachine {
    public static final Integer LOTTO_PRICE = 1000;

    private WinningLotto winningLotto;

    public void initWinningLotto(WinningLotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public List<Lotto> purchase(int money) {
        int count = money / LOTTO_PRICE;
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto());
        }

        return lottos;
    }

    public LottoResult createLottoResult(List<Lotto> lottos){
        if(winningLotto == null) {
            throw new IllegalArgumentException();
        }

        return lottos.stream()
            .map(winningLotto::matchLotto)
            .collect(Collectors.collectingAndThen(Collectors.toList(), LottoResult::new));
    }

    public LottoResult createLottoResult(Lotto ...lottos){
        return createLottoResult(Arrays.asList(lottos));
    }
}
