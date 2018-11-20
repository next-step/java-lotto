package lotto.domain;

public interface LottoResult {

    Integer getRankingCount(Rank rank);

    Money getTotalPrize();

}
