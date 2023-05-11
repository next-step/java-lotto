package study.lottogame.domain;

public class WinningLottery {

  private Lottery prizeLottery;
  private LottoNumber bonusLottoNumber;

  public WinningLottery(Lottery prizeLottery, LottoNumber bonusLottoNumber) {
    if (prizeLottery.matchLottoNumber(bonusLottoNumber)) {
      throw new IllegalArgumentException("유효하지 않은 입력입니다.");
    }

    this.prizeLottery = prizeLottery;
    this.bonusLottoNumber = bonusLottoNumber;
  }

  public Rank getRank(Lottery lottery) {
    int countOfMatch = lottery.matchLottoNumbers(prizeLottery);
    boolean matchBonus = lottery.matchLottoNumber(bonusLottoNumber);
    return Rank.valueOf(countOfMatch, matchBonus);
  }
}
