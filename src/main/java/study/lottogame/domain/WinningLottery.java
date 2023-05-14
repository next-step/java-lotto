package study.lottogame.domain;

public class WinningLottery {

  private Lottery prizeLottery;
  private LottoNumber bonusLottoNumber;

  public WinningLottery(Lottery prizeLottery, LottoNumber bonusLottoNumber) {
    if (prizeLottery.matchLottoNumber(bonusLottoNumber)) {
      throw new IllegalArgumentException("당첨 로또번호와 보너스 로또번호는 중복될 수 없습니다.");
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
