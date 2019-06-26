package com.jaeyeonling.lotto.domain;

import com.jaeyeonling.lotto.exception.EmptyLottoNumberException;
import com.jaeyeonling.lotto.utils.StringToLottoTransfer;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoTicket {

    public static final int MIN = 1;

    private final List<Lotto> lottos;

    public LottoTicket(final List<String> lottoNumbers) {
        if (Objects.isNull(lottoNumbers)) {
            throw new EmptyLottoNumberException();
        }

        this.lottos = lottoNumbers.stream()
                .map(StringToLottoTransfer::transform)
                .collect(Collectors.toList());
    }

    List<Lotto> getLottos() {
        return lottos;
    }
}
