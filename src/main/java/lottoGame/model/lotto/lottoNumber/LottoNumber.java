package lottoGame.model.lotto.lottoNumber;

public interface LottoNumber {
    void validateNum(int input);
    int getLottoNumber();
    boolean isMatchOrNot(int winningNumber);

}
