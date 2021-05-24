package study.step2.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoFactory {

  private static final int LOTTO_MIN_NUMBER = 1;
  private static final int LOTTO_MAX_NUMBER = 45;
  private static final int LOTTO_START_RANGE_NUMBER = 0;
  private static final int LOTTO_END_RANGE_NUMBER = 6;

  private static final List<Integer> lottoNumberKeys = new ArrayList<>();

  static {
    for (int i = LOTTO_MIN_NUMBER; i <= LOTTO_MAX_NUMBER; i++) {
      lottoNumberKeys.add(i);
    }
  }

  public static Set<LottoNumber> pick() {
    Collections.shuffle(lottoNumberKeys);

    List<Integer> pickedLottoNumbers = lottoNumberKeys.subList(LOTTO_START_RANGE_NUMBER, LOTTO_END_RANGE_NUMBER);

    Collections.sort(pickedLottoNumbers);

    return pickedLottoNumbers.stream()
        .map(LottoNumber::valueOf)
        .collect(Collectors.toCollection(LinkedHashSet::new));
  }

}
