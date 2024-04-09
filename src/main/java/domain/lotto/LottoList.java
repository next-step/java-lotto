package domain.lotto;

import domain.lotto.vo.LottoNumber;
import domain.lotto.vo.WinNumbers;
import domain.machine.LottoNumberGenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoList {

  private final List<Lotto> lottoList;

  public LottoList(LottoNumberGenerator lottoNumberGenerator, int count) {
    this.lottoList = generateLotto(lottoNumberGenerator, count);
  }

  public LottoList(){
    this.lottoList = new ArrayList<>();
  }

  public void generateAutoLotto(LottoNumberGenerator lottoNumberGenerator, int count) {
    this.lottoList.addAll(generateLotto(lottoNumberGenerator, count));
  }

  public void generateManualLotto(List<LottoNumber> lottoNumbers) {
    this.lottoList.addAll(generateLotto(lottoNumbers));
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
        .mapToObj(i -> generator.generate().stream().map(LottoNumber::of).collect(Collectors.toList()))
            .map(Lotto::new)
        .collect(Collectors.toList());
  }

  private  List<Lotto> generateLotto(List<LottoNumber> lottoNumbers){
    return List.of(new Lotto(lottoNumbers));
  }

  public int getLottoCount() {
    return lottoList.size();
  }

}
