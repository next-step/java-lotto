package application;

import domain.LottoTicket;
import util.OperationUtil;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoService {

    private final List<Integer> lottoRangeNumbers = OperationUtil.createLottoRangeNumbers();

    public LottoTicket createLottoTicket() {
        return new LottoTicket(getRandomSixNumbers(lottoRangeNumbers));
    }

    private List<Integer> getRandomSixNumbers(List<Integer> lottoRangeNumbers) {
        Collections.shuffle(lottoRangeNumbers);
        return lottoRangeNumbers.stream()
                .limit(6)
                .collect(Collectors.toList());
    }
}
