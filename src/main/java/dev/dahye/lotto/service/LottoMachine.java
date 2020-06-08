package dev.dahye.lotto.service;

import dev.dahye.lotto.domain.LottoMoney;
import dev.dahye.lotto.domain.LottoTicket;
import dev.dahye.lotto.domain.LottoTickets;

import java.util.List;

public class LottoMachine {
    private LottoTickets lottoTickets;

    public LottoMachine(LottoMoney lottoMoney) {
        int countOfLotto = lottoMoney.calculateCountOfLotto();
        lottoTickets = LottoTickets.autoIssued(countOfLotto);
    }

    public LottoMachine(LottoMoney lottoMoney, int countOfManualLotto, List<LottoTicket> manualLottoTickets) {
        int countOfLotto = lottoMoney.calculateCountOfLotto();
        validateManualLotto(countOfLotto, countOfManualLotto, manualLottoTickets);
        lottoTickets = LottoTickets.multiIssued(countOfLotto, manualLottoTickets);
    }

    private void validateManualLotto(int countOfLotto, int countOfManualLotto, List<LottoTicket> lottoTickets) {
        if (countOfLotto < countOfManualLotto) {
            throw new IllegalArgumentException("수동 로또 갯수는 전체 갯수를 초과할 수 없습니다.");
        }

        if (countOfManualLotto < 0) {
            throw new IllegalArgumentException("수동 로또 갯수는 음수일 수 없습니다.");
        }

        if (lottoTickets.size() != countOfManualLotto) {
            throw new IllegalArgumentException("수동 로또 갯수 만큼 로또 티켓을 입력해주세요.");
        }
    }

    public LottoTickets getLottoTickets() {
        return lottoTickets;
    }
}
