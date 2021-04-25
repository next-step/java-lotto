package step4.lotto.domain;

public interface LottoMatchable {
    void lottoMatching(Result result, WinningLotto winningLotto);

    Rank lottoRank(Lotto userLotto, WinningLotto winningLotto);
}
