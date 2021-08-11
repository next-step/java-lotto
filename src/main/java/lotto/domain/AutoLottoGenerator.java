package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class AutoLottoGenerator implements LottoGenerator {

    private static final List<LottoNumber> lottoNumbers = IntStream.rangeClosed(LottoNumber.MIN_NUMBER, LottoNumber.MAX_NUMBER)
            .boxed()
            .map(LottoNumber::new)
            .collect(Collectors.toList());

    @Override
    public LottoTicket generate() {
        List<LottoNumber> targetNumbers = shuffleLottoNumbers();
        return pickLottoNumbers(targetNumbers);
    }

    private List<LottoNumber> shuffleLottoNumbers() {
        List<LottoNumber> targetNumbers = new ArrayList<>(lottoNumbers);
        Collections.shuffle(targetNumbers);
        return targetNumbers;
    }

    private LottoTicket pickLottoNumbers(final List<LottoNumber> targetNumbers) {
        List<LottoNumber> lottoNumbers = targetNumbers.stream()
                .limit(LottoTicket.LOTTO_TICKET_SIZE)
                .sorted()
                .collect(Collectors.toList());

        return new LottoTicket(lottoNumbers);
    }
}