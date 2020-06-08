package lotto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoFactory {

  public static Lottos createLottosByQuickPick(int quantity) {
    List<Lotto> lottoList = new ArrayList<>();

    for (int i = 0; i < quantity; i++) {
      lottoList.add(new Lotto(LottoNumberPool.getInstance().quickPick()));
    }

    return new Lottos(lottoList);
  }

  public static Lottos createLottosByManual(String[] numberStrArr) {
    return new Lottos(
        Stream.of(numberStrArr)
            .map(s -> LottoFactory.createLottoByStrArr(s.split(",")))
            .collect(Collectors.toList()));
  }

  public static Lotto createLottoByStrArr(String[] numberArr) {
    List<LottoNumber> numberList = Stream.of(numberArr)
        .map(num -> new LottoNumber(Integer.parseInt(num.trim())))
        .collect(Collectors.toList());

    return new Lotto(numberList);
  }
}
