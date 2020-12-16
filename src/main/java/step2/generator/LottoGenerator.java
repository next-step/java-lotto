package step2.generator;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {

  public static final int LOTTO_MIN_NUMBER = 1;
  public static final int LOTTO_MAX_NUMBER = 45;
  public static final int ZERO = 0;
  public static final int LOTTO_NUMBER_LIMIT_SIZE = 6;
  public static final String COMMA_FLAG = ",";

  private LottoGenerator () {
  }

  public static List<List<Integer>> randomGenerateList(int size) {
    List<List<Integer>> userLottoList = new ArrayList<>();
    for (int i = 0; i < size; i ++) {
      userLottoList.add(randomGenerate());
    }
    return userLottoList;
  }

  private static List<Integer> randomGenerate() {
    List<Integer> lottoNumberList = IntStream.range(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER)
        .boxed()
        .collect(Collectors.toList());
    Collections.shuffle(lottoNumberList);
    return lottoNumberList.subList(ZERO, LOTTO_NUMBER_LIMIT_SIZE).stream()
        .sorted()
        .collect(Collectors.toList());
  }

  public static List<Integer> getLottoNumberListFromString(String numbers) {
    List<Integer> manualLotto = new ArrayList<>();
    for (String field: numbers.split(COMMA_FLAG)) {
      manualLotto.add(Integer.parseInt(field));
    }
    return manualLotto;
  }
}
