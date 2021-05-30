package lotto.domain;

public interface LottoNumberFactory {
    Number generateNumber(Integer customNumber);
    LottoNumber generateNumber();
    void setGenerateStrategy(Strategy strategy);
}
