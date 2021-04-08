package lotto.domain;

import lotto.domain.place.LottoPlaces;

public class LottoStore {
  private final LottoWiningNumbers lottoWiningNumbers;
  private final LottoPlaces lottoPlaces;

  private LottoStore(LottoWiningNumbers lottoWiningNumbers) {
    this(lottoWiningNumbers, LottoPlaces.create());
  }

  private LottoStore(LottoWiningNumbers lottoWiningNumbers, LottoPlaces lottoPlaces) {
    this.lottoWiningNumbers = lottoWiningNumbers;
    this.lottoPlaces = lottoPlaces;
  }

  public static LottoStore open(LottoWiningNumbers lottoWiningNumbers) {
    return new LottoStore(lottoWiningNumbers);
  }

  public LottoStore exchange(LottoTicket ticket) {
    return new LottoStore(lottoWiningNumbers, ticket.getMatchedLottoPlaces(lottoWiningNumbers));
  }

  public long totalWinMoney() {
    return this.lottoPlaces.totalWinMoney();
  }

  public LottoPlaces getLottoPlaces() {
    return lottoPlaces;
  }
}
