package domain.strategy;

import domain.lotto.LottoNumber;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenerateLottoNumRandom implements GenerateLottoNum {

  private final int LOTTOSIZE = 6;

  @Override
  public List<Integer> generate() {
    List<Integer> lottoNumsList = new ArrayList<>(LottoNumber.lottoNumbers);
    Collections.shuffle(lottoNumsList);
    lottoNumsList = lottoNumsList.subList(0, LOTTOSIZE);
    return lottoNumsList;
  }
}
