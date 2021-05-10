package study.step2.domain;


import static study.step2.utils.MessageUtil.LOTTO_NUMBER_INVALID_RANGE;
import static study.step2.utils.MessageUtil.VALIDATOR_NUMBER_MESSAGE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class LottoNumber implements Comparable<LottoNumber> {

  private static final int LOTTO_MIN_NUMBER = 1;
  private static final int LOTTO_MAX_NUMBER = 45;
  private static final int LOTTO_START_RANGE_NUMBER = 0;
  private static final int LOTTO_END_RANGE_NUMBER = 6;

  private static final Map<Integer, LottoNumber> lottoNumberMap = new HashMap<>();

  private static final List<Integer> lottoNumberKeys;

  private final int lottoNumber;

  static {
    for (int i = LOTTO_MIN_NUMBER; i <= LOTTO_MAX_NUMBER; i++) {
      lottoNumberMap.put(i, new LottoNumber(i));
    }

    lottoNumberKeys = new ArrayList<>(lottoNumberMap.keySet());
  }

  public LottoNumber(int lottoNumber) {
    if (lottoNumber < LOTTO_MIN_NUMBER || lottoNumber > LOTTO_MAX_NUMBER) {
      throw new IllegalArgumentException(LOTTO_NUMBER_INVALID_RANGE);
    }
    this.lottoNumber = lottoNumber;
  }

  public static LottoNumber valueOf(String s) {
    return lottoNumberMap.get(Integer.parseInt(s));
  }

  public static Set<LottoNumber> pick() {
    Collections.shuffle(lottoNumberKeys);

    List<Integer> pickedLottoNumbers = lottoNumberKeys.subList(LOTTO_START_RANGE_NUMBER, LOTTO_END_RANGE_NUMBER);

    return pickedLottoNumbers.stream().map(lottoNumberMap::get)
        .collect(Collectors.toCollection(TreeSet::new));
  }

  public void validatorPositiveNumber() {
    if (lottoNumber < 0) {
      throw new IllegalArgumentException(VALIDATOR_NUMBER_MESSAGE);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LottoNumber that = (LottoNumber) o;
    return lottoNumber == that.lottoNumber;
  }

  @Override
  public int hashCode() {
    return Objects.hash(lottoNumber);
  }

  @Override
  public String toString() {
    return String.valueOf(lottoNumber);
  }

  @Override
  public int compareTo(LottoNumber o) {
    return this.lottoNumber - o.lottoNumber;
  }

}
