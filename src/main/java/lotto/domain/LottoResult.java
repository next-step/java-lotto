package lotto.domain;

public interface LottoResult {
    Integer getValue(Rank rank);

    Money getPrize();
}
