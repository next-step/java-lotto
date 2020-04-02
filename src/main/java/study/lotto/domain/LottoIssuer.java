package study.lotto.domain;

@FunctionalInterface
public interface LottoIssuer {
    Lotto issue();
}
