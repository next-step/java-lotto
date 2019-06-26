package com.jaeyeonling.lotto.domain;

import com.jaeyeonling.lotto.exception.EmptyLottoNumberException;
import com.jaeyeonling.lotto.utils.StringToLottoTransfer;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoTicket {

    public static final int MIN = 1;

    private static final LottoTicket EMPTY = new LottoTicket(Collections.emptyList());

    private final List<Lotto> lottos;

    private LottoTicket(final List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static LottoTicket of(final List<String> lottoNumbers) {
        if (Objects.isNull(lottoNumbers)) {
            throw new EmptyLottoNumberException();
        }
        if (lottoNumbers.size() < MIN) {
            return empty();
        }

        final List<Lotto> lottos = lottoNumbers.stream()
                .map(StringToLottoTransfer::transform)
                .collect(Collectors.toList());

        return new LottoTicket(lottos);
    }

    public static LottoTicket empty() {
        return EMPTY;
    }

    List<Lotto> getLottos() {
        return lottos;
    }
}
