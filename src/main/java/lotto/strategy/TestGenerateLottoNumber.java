package lotto.strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.LottoNumber;

public class TestGenerateLottoNumber implements GenerateLottoNumber{

  private int startIndex;

  private int endIndex;

  private List<Integer> testLottoNumbers = new ArrayList<>();

  public TestGenerateLottoNumber(int start, int end) {
    this.startIndex = start;
    this.endIndex = end;
  }

  public TestGenerateLottoNumber(int start, int end, List<Integer>testLottoNumbers) {
    this.startIndex = start;
    this.endIndex = end;
    this.testLottoNumbers = testLottoNumbers;
  }

  @Override
  public List<LottoNumber> createNumberPull() {
    return IntStream.range(startIndex, endIndex)
        .mapToObj(i -> new LottoNumber(selectNumberMode(i))).collect(Collectors.toList());
  }

  private Integer selectNumberMode(int i) {
    if (!testLottoNumbers.isEmpty()){
      return testLottoNumbers.get(i);
    }
    return i;
  }
}
