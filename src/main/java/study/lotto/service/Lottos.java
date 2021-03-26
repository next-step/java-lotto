package study.lotto.service;

import study.lotto.domain.Lotto;
import study.lotto.domain.WinningLotto;
import study.lotto.domain.type.LottoMatch;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static study.lotto.util.Constants.LOTTO_PRICE;

/**
 * Lotto 클래스의 일급 컬렉션
 */
public class Lottos {

    // 전체 로또 생성
    private final List<Lotto> lottoList;

    public Lottos(final List<Lotto> lotteries) {
        this.lottoList = lotteries;
    }

    public long matchStatics(final LottoMatch lottoMatch, final WinningLotto winningLotto) {
        return lottoList.stream()
                .collect(groupingBy(winningLotto::match, counting()))
                .getOrDefault(lottoMatch, 0L);
    }

    public double winningRate(final WinningLotto winningLotto) {
        long sum = lottoList.stream()
                .mapToLong(winningLotto::winningReward)
                .sum();
        return rate(sum);
    }

    private double rate(final long sum) {
        return (double) sum / (lottoList.size() * LOTTO_PRICE);
    }

    public List<Lotto> lottoList() {
        return Collections.unmodifiableList(lottoList);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Lottos lottos = (Lottos) o;
        return Objects.equals(lottoList, lottos.lottoList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoList);
    }
}
