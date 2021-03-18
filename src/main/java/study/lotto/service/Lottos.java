package study.lotto.service;

import study.lotto.domain.Lotto;
import study.lotto.domain.LottoNumber;
import study.lotto.domain.type.LottoMatch;
import study.lotto.view.dto.RequestMoney;
import study.lotto.view.dto.RequestWinningNumber;

import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

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

    public long statics(LottoMatch lottoMatch, RequestWinningNumber winningNumber, LottoNumber bonusNumber) {
        return lottoList.stream()
                .collect(
                        groupingBy(lotto -> lotto.match(winningNumber, bonusNumber), counting())
                )
                .getOrDefault(lottoMatch, 0L);
    }

    public double winningRate(RequestWinningNumber winningNumber, LottoNumber bonusNumber) {
        long sum = lottoList.stream()
                .mapToLong(lotto -> lotto.winningReward(winningNumber, bonusNumber))
                .sum();
        return money.winningRate(sum);
    }
}
