package lotto.util;

import lotto.domain.LottoGame;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TestUtil {

  private TestUtil() {}

  public static List<LottoNumber> toNumbers(String numbersString) {
    return Arrays.stream(numbersString.split(","))
        .map(numberString -> new LottoNumber(Integer.parseInt(numberString)))
        .collect(Collectors.toList());
  }

  public static List<LottoNumber> getOneToSixLottoNumbers() {
    return IntStream.range(1, 7)
        .mapToObj(LottoNumber::new)
        .collect(Collectors.toList());
  }

  public static LottoGame createAutoLottoGameFromLottoNumbers(String numbers) {
    return LottoGame.createAutoGame(new LottoNumbers(toNumbers(numbers)));
  }

}
