package step2.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static step2.domain.Lotto.ofRandomLotto;

public class LottosGenerator {

    public static List<Lotto> getAutoLottos(int gameCount) {
        return IntStream.range(0, gameCount).mapToObj(i -> ofRandomLotto()).collect(Collectors.toList());
    }

    public static List<Lotto> getManualLottos(List<String> strings) {
        return strings.stream()
                      .map(inputManualLottoNumber -> Lotto.ofLotto(LottoNumbers.convertStringToNo(inputManualLottoNumber)))
                      .collect(Collectors.toList());
    }
}
