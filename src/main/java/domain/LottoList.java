package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoList {

  private List<Lotto> lottoList;

  public LottoList(LottoNumberGenerator lottoNumberGenerator, int count) {
    this.lottoList = generateLotto(lottoNumberGenerator, count);
  }

  public List<List<Integer>> getLottoNumbers() {
    return lottoList.stream().map(Lotto::getNumbers).collect(Collectors.toList());
  }

  public Map<Integer, Integer>getLottoResult(Set<Integer> winningNumbers) {
    Map<Integer, Integer> result = new HashMap<>();
    for(Lotto lotto : lottoList){
     Integer count = getMatchCount(winningNumbers, lotto.getNumbers());
     result.put(count, result.getOrDefault(count, 0) + 1);
    }
    return result;
  }

  private List<Lotto> generateLotto(LottoNumberGenerator generator, int count){
    return IntStream.range(0, count)
        .mapToObj(i -> new Lotto(generator.generate()))
        .collect(Collectors.toList());
  }

  public int getMatchCount(Set<Integer> winningNumbers, List<Integer> lottoNumbers) {
    return lottoNumbers.stream()
                    .reduce(0, (acc, number) -> acc + (winningNumbers.contains(number) ? 1 : 0));
  }

  public int getLottoCount() {
    return lottoList.size();
  }

}
