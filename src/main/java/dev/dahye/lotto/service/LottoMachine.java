package dev.dahye.lotto.service;

import dev.dahye.lotto.domain.LottoMoney;
import dev.dahye.lotto.domain.LottoTicket;
import dev.dahye.lotto.domain.LottoTickets;

import java.util.List;

public class LottoMachine {
    private final LottoTickets lottoTickets;
    private final int countOfManualLotto;

    public LottoMachine(LottoMoney lottoMoney, int countOfManualLotto, List<LottoTicket> manualLottoTickets) {
        int countOfLotto = lottoMoney.calculateCountOfLotto();
        this.countOfManualLotto = countOfManualLotto;
        validateManualLotto(countOfLotto, manualLottoTickets);
        lottoTickets = LottoTickets.multiIssued(countOfLotto, manualLottoTickets);
    }

    private void validateManualLotto(int countOfLotto, List<LottoTicket> lottoTickets) {
        validateGreaterThan(countOfLotto, countOfManualLotto, "수동 로또 갯수는 전체 갯수를 초과할 수 없습니다.");
        validateGreaterThan(countOfManualLotto, 0, "수동 로또 갯수는 음수일 수 없습니다.");
        validateCountOfManualLottoTickets(lottoTickets);
    }

    private void validateGreaterThan(int countOfLotto, int countOfManualLotto, String s) {
        if (countOfLotto < countOfManualLotto) {
            throw new IllegalArgumentException(s);
        }
    }

    private void validateCountOfManualLottoTickets(List<LottoTicket> lottoTickets) {
        if (lottoTickets.size() != countOfManualLotto) {
            throw new IllegalArgumentException("수동 로또 갯수 만큼 로또 티켓을 입력해주세요.");
        }
    }

    public LottoTickets getLottoTickets() {
        return lottoTickets;
    }

    public int getCountOfManualLotto() {
        return countOfManualLotto;
    }

    public int getCountOfAutoLotto() {
        return this.lottoTickets.size() - countOfManualLotto;
    }
}
