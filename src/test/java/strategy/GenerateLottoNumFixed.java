package strategy;

import domain.strategy.GenerateLottoNum;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class GenerateLottoNumFixed implements GenerateLottoNum {

  @Override
  public List<Integer> generate() {
    int [] LottoNum = {1,2,3,4,5,6};
    return Arrays.stream(LottoNum).boxed().collect(Collectors.toList());
  }
}
