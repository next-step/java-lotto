package lotto.domain;

import lotto.domain.place.LottoPlaces;

public class LottoStore {
  private final LottoWiningNumbers lottoWiningNumbers;
  private final LottoPlaces lottoPlaces;
  private final LottoBonusBall lottoBonusBall;

  private LottoStore(LottoWiningNumbers lottoWiningNumbers, int lottoBonusBallNumber) {
    this(lottoWiningNumbers, LottoBonusBall.create(lottoBonusBallNumber), LottoPlaces.create());
  }

  private LottoStore(LottoWiningNumbers lottoWiningNumbers, LottoBonusBall lottoBonusBall, LottoPlaces lottoPlaces) {
    this.lottoWiningNumbers = lottoWiningNumbers;
    this.lottoPlaces = lottoPlaces;
    this.lottoBonusBall = lottoBonusBall;
  }

  public static LottoStore open(LottoWiningNumbers lottoWiningNumbers, int lottoBonusBallNumber) {
    return new LottoStore(lottoWiningNumbers, lottoBonusBallNumber);
  }

  public LottoStore exchange(LottoTicket ticket) {
    return new LottoStore(lottoWiningNumbers, lottoBonusBall, ticket.getMatchedLottoPlaces(lottoWiningNumbers, lottoBonusBall));
  }

  public long totalWinMoney() {
    return this.lottoPlaces.totalWinMoney();
  }

  public LottoPlaces getLottoPlaces() {
    return lottoPlaces;
  }
}
