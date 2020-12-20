package com.ssabae.nextstep.lotto.domain.lotto.ticketgenerator;

import static com.ssabae.nextstep.lotto.Constant.LOTTO_MAX_VALUE;
import static com.ssabae.nextstep.lotto.Constant.LOTTO_MIN_VALUE;
import static com.ssabae.nextstep.lotto.Constant.LOTTO_NUMBER_SIZE;

import com.ssabae.nextstep.lotto.domain.lotto.LottoNumber;
import com.ssabae.nextstep.lotto.domain.lotto.LottoTicket;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : leesangbae
 * @project : java-lotto
 * @since : 2020-12-18
 */
public class AutoLottoTicketGenerator implements LottoTicketGenerator {

    private final List<LottoNumber> lottoNumbers;

    public AutoLottoTicketGenerator() {
        lottoNumbers = new ArrayList<>();
        for (int i = LOTTO_MIN_VALUE; i <= LOTTO_MAX_VALUE; i++) {
            lottoNumbers.add(LottoNumber.of(i));
        }
    }

    @Override
    public LottoTicket generate() {
        Collections.shuffle(lottoNumbers);
        List<LottoNumber> lottoNumbers = this.lottoNumbers
                .subList(0, LOTTO_NUMBER_SIZE)
                .stream()
                .sorted(Comparator.comparingInt(LottoNumber::getNumber))
                .collect(Collectors.toList());
        return new LottoTicket(lottoNumbers);
    }
}
