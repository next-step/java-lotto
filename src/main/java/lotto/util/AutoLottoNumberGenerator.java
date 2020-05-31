package lotto.util;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.LottoNumber;

public class AutoLottoNumberGenerator implements LottoNumberGenerator {

  private static final int MINIMUM_NUMBER_BOUND = 1;
  private static final int MAXIMUM_NUMBER_BOUND = 45;
  private static final int START_INDEX_OF_NUMBER_ELEMENTS = 0;
  private static final int NUMBER_OF_NUMBER_ELEMENTS = 6;

  public static List<LottoNumber> generateLottoNumbers() {
    return IntStream.rangeClosed(MINIMUM_NUMBER_BOUND, MAXIMUM_NUMBER_BOUND)
        .mapToObj(LottoNumber::new)
        .collect(Collectors.toList());
  }

  public static List<LottoNumber> shuffle() {
    Collections.shuffle(generateLottoNumbers());
    return Collections.unmodifiableList(pickList());
  }

  private static List<LottoNumber> pickList() {
    List<LottoNumber> lottoNumberList =
        generateLottoNumbers().subList(START_INDEX_OF_NUMBER_ELEMENTS, NUMBER_OF_NUMBER_ELEMENTS);
    sortDescLottoNumbers(lottoNumberList);
    return lottoNumberList;
  }

  private static void sortDescLottoNumbers(List<LottoNumber> lottoNumberList) {
    lottoNumberList.sort(Comparator.comparing(LottoNumber::getNumber));
  }
}
