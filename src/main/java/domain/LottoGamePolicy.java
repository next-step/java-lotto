package domain;

public interface LottoGamePolicy {
    LottoGamePrize rank(long matchCount, boolean isMatchBonus);
}
