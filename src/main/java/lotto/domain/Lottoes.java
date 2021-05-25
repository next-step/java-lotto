package lotto.domain;

import lotto.generator.NumberGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Lottoes {
    private final List<Lotto> lottoes;

    private Lottoes() {
        this.lottoes = new ArrayList<>();
    }

    public static Lottoes init() {
        return new Lottoes();
    }

    public void buyManualLotto(final List<Integer> lottoNumbers) {
        this.lottoes.add(Lotto.from(lottoNumbers));
    }

    public void buyAutoLotto(final NumberGenerator numberGenerator) {
        this.lottoes.add(Lotto.from(numberGenerator));
    }

    public int getLottoCount() {
        return lottoes.size();
    }

    public int getRankCount(final WinningLotto winningLotto, final Rank criteriaRank) {
        return (int) lottoes.stream()
                .map(lotto -> winningLotto.getRank(lotto))
                .filter(rank -> rank.equals(criteriaRank))
                .count();
    }

    public List<Lotto> getLottoes() {
        return Collections.unmodifiableList(lottoes);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lottoes lottoes1 = (Lottoes) o;
        return Objects.equals(lottoes, lottoes1.lottoes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoes);
    }
}
