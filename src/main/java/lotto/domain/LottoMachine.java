package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.exception.MoneyException;

public class LottoMachine {

    private final LottoPolicy lottoPolicy;

    public LottoMachine(LottoPolicy lottoPolicy) {
        this.lottoPolicy = lottoPolicy;
    }

    public Lottos buyLotto(int buyMoney) {
        validation(buyMoney);
        int lottoCount = buyMoney / 1000;

        List<Lotto> lottoList = IntStream.range(0, lottoCount)
            .mapToObj(__ -> lottoPolicy.ball())
            .collect(Collectors.toList());
        return new Lottos(lottoList);
    }

    private void validation(int buyMoney) {
        if (buyMoney < 1000) {
            throw new MoneyException("1000원 이하로는 구매할 수 없습니다.");
        }
    }
}
