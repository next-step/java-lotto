package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import static lotto.domain.LottoRule.ALL_NUMBERS;
import static lotto.domain.LottoRule.NUMBERS_IN_GAME;

public class LottoVendingMachine {
    final static int PRICE = 1000;

    private final LottoNumbers lottoNumbers;

    public LottoVendingMachine() {
        this(ALL_NUMBERS);
    }

    public LottoVendingMachine(LottoNumbers lottoNumbers) {
        validate(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validate(LottoNumbers lottoNumbers) {
        if (lottoNumbers == null) {
            throw new IllegalArgumentException("LottoVendingMachine은 lottoNumbers없이 생성할 수 없습니다.");
        }
    }

    public LottoTickets vend(Amount amount) {
        List<LottoTicket> lottoTickets = new ArrayList<>();

        for (int i = 0; i < amount.getValue() / PRICE; i++) {
            lottoTickets.add(new LottoTicket(lottoNumbers.getRandomNumbers(NUMBERS_IN_GAME)));
        }

        return new LottoTickets(lottoTickets);
    }
}
