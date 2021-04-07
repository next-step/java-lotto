package lotto.domain;

import lotto.domain.place.LottoPlaces;
import lotto.function.GenerateNumbers;

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

  public static LottoStore open(GenerateNumbers generateNumbers) {
    return open(LottoWiningNumbers.generate(generateNumbers));
  }

  public static LottoStore open(LottoWiningNumbers lottoWiningNumbers) {
    return new LottoStore(lottoWiningNumbers);
  }

  public LottoStore exchange(LottoTicket ticket) {
    LottoStore store = this;
    for (LottoNumbers lottoNumbers : ticket.getLottoNumbers()) {
      int matchedLottoNumberCount = lottoWiningNumbers.matchLottoNumber(lottoNumbers);
      store = new LottoStore(store.lottoWiningNumbers, store.lottoPlaces.record(matchedLottoNumberCount));
    }
    return store;
  }

  public LottoWiningNumbers getLottoWiningNumbers() {
    return lottoWiningNumbers;
  }

  public LottoPlaces getLottoPlaces() {
    return lottoPlaces;
  }
}
