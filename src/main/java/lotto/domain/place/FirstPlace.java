package lotto.domain.place;

public class FirstPlace extends Place {
  protected FirstPlace(int count) {
    super(Rank.FIRST, count);
  }

  public static Place create() {
    return new FirstPlace(0);
  }

  @Override
  public Place win() {
    return new FirstPlace(plusCount());
  }
}
