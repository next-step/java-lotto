package lotto.domain.lottoMachine;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import lotto.domain.Lotto;
import lotto.domain.LottoBall;
import lotto.domain.LottoMachine;
import lotto.domain.LottoRequest;
import lotto.domain.LottoTicket;
import lotto.utils.LottoHelper;

public class ManualLottoMachine implements LottoMachine {

    @Override
    public LottoTicket createLotto(LottoRequest lottoRequest) {
        return LottoTicket.of(create(lottoRequest));
    }
    
    private List<Lotto> create(LottoRequest lottoRequest) {
        if (lottoRequest.getManualLottoValues() == null) {
            return Collections.emptyList();
        }

        return Arrays.stream(lottoRequest.getManualLottoValues())
                .map(value -> LottoHelper.toInts(LottoHelper.split(value)))
                .map(numbers -> Lotto.ofManual(toLottoBalls(numbers)))
                .collect(Collectors.toList());
    }

    private List<LottoBall> toLottoBalls(int[] numbers) {
        return Arrays.stream(numbers)
                .mapToObj(number -> LottoBall.of(number))
                .collect(Collectors.toList());
    }

}
