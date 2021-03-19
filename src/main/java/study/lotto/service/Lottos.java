package study.lotto.service;

import study.lotto.domain.Lotto;
import study.lotto.domain.WinningLotto;
import study.lotto.domain.type.LottoMatch;
import study.lotto.view.dto.RequestMoney;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * Lotto 클래스의 일급 컬렉션
 */
public class Lottos {

    // 전체 로또 생성
    private final List<Lotto> lottoList;
    private final RequestMoney money;

    public Lottos(final List<Lotto> lotteries) {
        this(lotteries, null);
    }

    public Lottos(final List<Lotto> lotteries, final RequestMoney money) {
        this.lottoList = lotteries;
        this.money = money;
    }

    public long statics(final LottoMatch lottoMatch, final WinningLotto winningLotto) {
        return lottoList.stream()
                .collect(groupingBy(winningLotto::match, counting()))
                .getOrDefault(lottoMatch, 0L);
    }

    public double winningRate(final WinningLotto winningLotto) {
        long sum = lottoList.stream()
                .mapToLong(winningLotto::winningReward)
                .sum();
        return money.winningRate(sum);
    }

    public List<Lotto> lottoList() {
        return Collections.unmodifiableList(lottoList);
    }

    public List<Lotto> addAll(List<Lotto> autoLotto) {
        return Stream.concat(lottoList.stream(), autoLotto.stream())
                .collect(Collectors.toList());
    }
}
