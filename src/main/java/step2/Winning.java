package step2;

public class Winning {

  private Lotto winner;

  public Winning(Lotto winner) {
    this.winner = winner;
  }

  public boolean isWinner(Lotto lotto) {
    return winner.equals(lotto);
  }
}
