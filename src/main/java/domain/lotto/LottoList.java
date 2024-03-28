package domain.lotto;

import domain.lotto.vo.WinNumbers;
import domain.machine.LottoNumberGenerator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoList {

  private List<Lotto> lottoList;

  public LottoList(LottoNumberGenerator lottoNumberGenerator, int count) {
    this.lottoList = generateLotto(lottoNumberGenerator, count);
  }

  public List<Lotto> getLottoNumbers() {
    return lottoList;
  }

  public Map<Integer, Integer> getLottoResult(WinNumbers winningNumbers) {
    Map<Integer, Integer> result = new HashMap<>();
    for(Lotto lotto : lottoList){
     Integer count = winningNumbers.getMatchCount(lotto.getNumbers());
     result.put(count, result.getOrDefault(count, 0) + 1);
    }
    return result;
  }

  private List<Lotto> generateLotto(LottoNumberGenerator generator, int count){
    return IntStream.range(0, count)
        .mapToObj(i -> new Lotto(generator.generate()))
        .collect(Collectors.toList());
  }

  public int getLottoCount() {
    return lottoList.size();
  }

}
