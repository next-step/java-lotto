package lotto.dto;

import java.util.Collections;
import java.util.List;
import lotto.domain.Lotteries;
import lotto.domain.Lotto;

public class LotteriesDto {

  private final List<Lotto> lottosDto;

  private LotteriesDto(final Lotteries lotteries) {
    this.lottosDto = Collections.unmodifiableList(lotteries.toList());
  }

  public static LotteriesDto of (final Lotteries lotteries){
    return new LotteriesDto(lotteries);
  }

  public List<Lotto> values(){
    return lottosDto;
  }

}