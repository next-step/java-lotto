package lotto.domain.raffle;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 한국 동행복권 6/45 로또 숫자 생성기
 */
public class BaseKoreaLottoRaffleGenerator implements LottoRaffleGenerator {

  private static final int LOTTO_NUMBER_SIZE = 6;

  @Override
  public List<Integer> generateRaffleNumber () {
    List<Integer> lottoNumbers = getAll645LottoNumbers();
    Collections.shuffle(lottoNumbers);
    return lottoNumbers.subList(0, LOTTO_NUMBER_SIZE);
  }

  public List<Integer> getAll645LottoNumbers() {
    return IntStream.rangeClosed(1, 45)
        .boxed()
        .collect(Collectors.toList());
  }
}
