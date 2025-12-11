package lottogame.model.lotto.generator;

import static java.util.Objects.isNull;
import static lottogame.model.lotto.LottoMachine.DELIMITER;
import static lottogame.model.lotto.LottoNum.convertToBundle;
import static lottogame.model.util.StringUtils.splitAndParseToInt;

import java.util.List;
import java.util.Set;
import lottogame.model.lotto.Lotto;
import lottogame.model.lotto.LottoNum;
import lottogame.model.lotto.Lottos;

public class ManualLottosGenerator implements LottosGenerator {

    private final List<String> manualLottos;

    public ManualLottosGenerator(List<String> manualLottos) {
        if (isNull(manualLottos) || manualLottos.isEmpty()) {
            throw new IllegalArgumentException("수동로또 번호를 적어주세요.");
        }

        this.manualLottos = manualLottos;
    }

    @Override
    public Lottos generateLottos() {
        List<Lotto> manualLottos = this.manualLottos.stream()
                .map(lottoNums -> {
                    Set<LottoNum> manualLottoNums = convertToBundle(
                            splitAndParseToInt(lottoNums, DELIMITER));

                    return new Lotto(manualLottoNums);
                }).toList();

        return new Lottos(manualLottos);
    }
}
