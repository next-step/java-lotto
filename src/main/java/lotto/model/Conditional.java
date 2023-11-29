package lotto.model;

@FunctionalInterface
public interface Conditional {

    boolean test(LottoRank lottoRank);
}
