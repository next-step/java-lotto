package lotto.domain.lottoMachine;

import lotto.domain.Lotto;
import lotto.domain.LottoBall;
import lotto.domain.LottoMachine;
import lotto.domain.LottoRequest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MaunalLottoMachine implements LottoMachine {

    @Override
    public List<Lotto> createLotto(LottoRequest lottoRequestCard) {
        if (lottoRequestCard.getManualGameTimes() == 0) return null;
        return lottoRequestCard.getManualLottoNumbers().stream()
                .map(numbers -> new Lotto(Lotto.LottoType.MANUAL, toLottoBalls(numbers)))
                .collect(Collectors.toList());
    }

    private List<LottoBall> toLottoBalls(int[] numbers) {
        return Arrays.stream(numbers)
                .mapToObj(number -> LottoBall.of(number))
                .collect(Collectors.toList());
    }
}
