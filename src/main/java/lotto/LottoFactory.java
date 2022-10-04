package lotto;

import lotto.controller.InputView;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.service.LottoNumberPicker;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoFactory {

    public static Lottos getManualLottos(InputView inputView, Integer manualLottoNumber) {
        return Lottos.getManualLottos(IntStream.range(0, manualLottoNumber)
                .mapToObj((idx) -> new Lotto(LottoNumberPicker.pick(inputView.getManualNumber())))
                .collect(Collectors.toList()));
    }
}
