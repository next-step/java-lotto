package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AutoLottoTicket extends LottoTicket {
    private static final int START_INDEX = 0;

    public AutoLottoTicket(List<Integer> lottoNumbers) {
        super(lottoNumbers);
    }

    @Override
    protected List<Integer> createLottoNumber(List<Integer> lottoNumbers) {
        final List<Integer> lottoNumberCollections = IntStream.rangeClosed(START_LOTTO_NUMBER, END_LOTTO_NUMBER)
                .boxed()
                .collect(Collectors.toList());
        Collections.shuffle(lottoNumberCollections);
        return lottoNumberCollections.subList(START_INDEX, NUMBER_OF_LOTTO_NUMBERS);
    }
}
