package step4.lotto.domain;

public interface LottoMatchable {
    void matching(Result result, WinningLotto winningLotto);

    Rank match(Lotto userLotto, WinningLotto winningLotto);
}
