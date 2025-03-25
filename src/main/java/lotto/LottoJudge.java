package lotto;

public class LottoJudge {

  private final Lotto winningLotto;

  public LottoJudge(Lotto winningLotto) {
    this.winningLotto = winningLotto;
  }

  public int judgeCount(Lotto lotto) {

    return (int)lotto.getNumbers().stream()
            .filter(winningLotto.getNumbers()::contains)
            .count();
  }
}
