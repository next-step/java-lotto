package lotto.domain.place;

public class SecondPlace extends Place {
  protected SecondPlace(int count) {
    super(Rank.SECOND, count);
  }

  public static Place create() {
    return new SecondPlace(0);
  }

  @Override
  public Place win() {
    return new SecondPlace(plusCount());
  }
}
