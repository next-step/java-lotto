package lotto.domain;

import lotto.domain.place.LottoPlaces;

public class LottoStore {
  private final LottoWiningNumbers lottoWiningNumbers;
  private final LottoPlaces lottoPlaces;
  private final int lottoBonusBall;

  private LottoStore(LottoWiningNumbers lottoWiningNumbers, int lottoBonusBall) {
    this(lottoWiningNumbers, lottoBonusBall, LottoPlaces.create());
  }

  private LottoStore(LottoWiningNumbers lottoWiningNumbers, int lottoBonusBall, LottoPlaces lottoPlaces) {
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
