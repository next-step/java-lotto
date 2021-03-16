package study.lotto.service;

import study.lotto.domain.Lotto;
import study.lotto.view.dto.RequestMoney;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lottos {
    private List<Lotto> lotteries;

    // 로또 전체 게임 생성
    public void makeLotto(RequestMoney money) {
        int totalLottoCount = money.getTotalLottoCount();
        lotteries = Stream.generate(Lotto::new)
                .limit(totalLottoCount)
                .collect(Collectors.toList());
    }

    public List<Lotto> getLotteries() {
        return Collections.unmodifiableList(lotteries);
    }
}
