package com.jaeyeonling.lotto.domain;

import com.jaeyeonling.lotto.exception.EmptyLottoNumberException;
import com.jaeyeonling.lotto.utils.ListUtils;
import com.jaeyeonling.lotto.utils.StringToLottoTransfer;

import java.util.List;
import java.util.stream.Collectors;

public class LottoTicket {

    private final List<Lotto> lottos;

    public LottoTicket(final List<String> lottoNumbers) {
        if (ListUtils.isNullOrEmpty(lottoNumbers)) {
            throw new EmptyLottoNumberException();
        }

        this.lottos = lottoNumbers.stream()
                .map(StringToLottoTransfer::transform)
                .collect(Collectors.toList());
    }


}
