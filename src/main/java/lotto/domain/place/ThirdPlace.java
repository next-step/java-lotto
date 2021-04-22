package lotto.domain.place;

public class ThirdPlace extends Place {
  protected ThirdPlace(int count) {
    super(Rank.THIRD, count);
  }

  public static Place create() {
    return new ThirdPlace(0);
  }

  @Override
  public Place win() {
    return new ThirdPlace(plusCount());
  }
}
