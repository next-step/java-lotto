package lotto.domain.place;

public class FifthPlace extends Place {
  protected FifthPlace(int count) {
    super(Rank.FIFTH, count);
  }

  public static Place create() {
    return new FifthPlace(0);
  }

  @Override
  public Place win() {
    return new FifthPlace(plusCount());
  }
}
