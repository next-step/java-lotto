package lotto.domain.place;

public class FourthPlace extends Place {
  protected FourthPlace(int count) {
    super(Rank.FOURTH, count);
  }

  public static Place create() {
    return new FourthPlace(0);
  }

  @Override
  public Place win() {
    return new FourthPlace(plusCount());
  }
}
