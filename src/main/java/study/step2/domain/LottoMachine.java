package study.step2.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class LottoMachine {

  private static final int LOTTO_MIN_NUMBER = 1;
  private static final int LOTTO_MAX_NUMBER = 45;
  private static final int LOTTO_START_RANGE_NUMBER = 0;
  private static final int LOTTO_END_RANGE_NUMBER = 6;

  private static final Map<Integer, LottoNumber> lottoNumberMap = new HashMap<>();
  private static final List<Integer> lottoNumberKeys;

  static {
    for (int i = LOTTO_MIN_NUMBER; i <= LOTTO_MAX_NUMBER; i++) {
      lottoNumberMap.put(i, new LottoNumber(i));
    }

    lottoNumberKeys = new ArrayList<>(lottoNumberMap.keySet());
  }

  private LottoMachine() {
  }

  public static Map<Integer, LottoNumber> getLottoNumberMap() {
    return lottoNumberMap;
  }

  public static Set<LottoNumber> pick() {
    Collections.shuffle(lottoNumberKeys);

    List<Integer> pickedLottoNumbers = lottoNumberKeys.subList(LOTTO_START_RANGE_NUMBER, LOTTO_END_RANGE_NUMBER);

    return pickedLottoNumbers.stream().map(lottoNumberMap::get)
        .collect(Collectors.toCollection(TreeSet::new));
  }

}
