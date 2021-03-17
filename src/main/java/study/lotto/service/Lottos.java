package study.lotto.service;

import study.lotto.domain.Lotto;
import study.lotto.view.dto.RequestMoney;

import java.util.Collections;
import java.util.List;

/**
 * Lotto 클래스의 일급 컬렉션
 */
public class Lottos {

    // 전체 로또 생성
    private final List<Lotto> lottoList;
    private final RequestMoney money;

    public Lottos(final List<Lotto> lotteries, final RequestMoney money) {
        this.lottoList = lotteries;
        this.money = money;
    }

    public List<Lotto> getLottoList() {
        return Collections.unmodifiableList(lottoList);
    }

    public int paidMoney() {
        return money.getMoney();
    }
}
