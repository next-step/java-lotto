package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public final class AutoLottoGenerator implements LottoGenerator {

    @Override
    public LottoTicket generate() {
        List<LottoNumber> targetLottoNumbers = generateTargetLottoNumbers();
        return pickLottoNumbers(targetLottoNumbers);
    }

    private List<LottoNumber> generateTargetLottoNumbers() {
        List<LottoNumber> targetNumbers = new ArrayList<>(LottoNumber.lottoNumbers);
        Collections.shuffle(targetNumbers);
        return targetNumbers;
    }

    private LottoTicket pickLottoNumbers(final List<LottoNumber> targetNumbers) {
        List<LottoNumber> lottoNumbers = targetNumbers.stream()
                .limit(LottoTicket.SIZE)
                .sorted()
                .collect(Collectors.toList());

        return new LottoTicket(lottoNumbers);
    }
}