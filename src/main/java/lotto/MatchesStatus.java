package lotto;

public class MatchesStatus {

  private Integer three = 0;
  private Integer four = 0;
  private Integer five = 0;
  private Integer six = 0;

  public void findMatches(Integer matchesNumber) {
    if (matchesNumber == 3) {
      findThreeMatches();
    } else if (matchesNumber == 4) {
      findFourMatches();
    } else if (matchesNumber == 5) {
      findFiveMatches();
    } else if (matchesNumber == 6) {
      findSixMatches();
    }
  }

  private void findThreeMatches() {
    three++;
  }

  private void findFourMatches() {
    four++;
  }

  private void findFiveMatches() {
    five++;
  }

  private void findSixMatches() {
    six++;
  }

  public Integer getThreeMatches() {
    return three;
  }

  public Integer getFourMatches() {
    return four;
  }

  public Integer getFiveMatches() {
    return five;
  }

  public Integer getSixMatches() {
    return six;
  }
}
