package lotto.domain;

public interface LottoNumberFactory {
    LottoNumber generateNumber();
    void setGenerateStrategy(Strategy strategy);
}
