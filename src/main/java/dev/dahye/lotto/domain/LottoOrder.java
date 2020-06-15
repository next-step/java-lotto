package dev.dahye.lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LottoOrder {
    private final LottoMoney lottoMoney;
    private final List<LottoTicket> lottoTickets;

    private LottoOrder(LottoMoney lottoMoney, int countOfManualLotto, List<LottoTicket> lottoTickets) {
        Objects.requireNonNull(lottoMoney, "lottoMoney must not be null");
        lottoTickets = initialLottoTickets(lottoTickets);
        validateManualLotto(lottoMoney, countOfManualLotto);
        validateCountOfManualLottoTickets(countOfManualLotto, lottoTickets);

        this.lottoMoney = lottoMoney;
        this.lottoTickets = lottoTickets;
    }

    private List<LottoTicket> initialLottoTickets(List<LottoTicket> lottoTickets) {
        if (lottoTickets == null) {
            lottoTickets = new ArrayList<>();
        }

        return lottoTickets;
    }

    private void validateManualLotto(LottoMoney lottoMoney, int countOfManualLotto) {
        validateGreaterThan(lottoMoney.calculateCountOfLotto(), countOfManualLotto, "수동 로또 갯수는 전체 갯수를 초과할 수 없습니다.");
        validateGreaterThan(countOfManualLotto, 0, "수동 로또 갯수는 음수일 수 없습니다.");
    }

    private void validateGreaterThan(int countOfLotto, int countOfManualLotto, String s) {
        if (countOfLotto < countOfManualLotto) {
            throw new IllegalArgumentException(s);
        }
    }

    private void validateCountOfManualLottoTickets(int countOfManualLotto, List<LottoTicket> manualLottoTickets) {
        if (manualLottoTickets.size() != countOfManualLotto) {
            throw new IllegalArgumentException("수동 로또 갯수 만큼 로또 티켓을 입력해주세요.");
        }
    }

    public static LottoOrder of(LottoMoney lottoMoney, int countOfManualLotto, List<LottoTicket> lottoTickets) {
        return new LottoOrder(lottoMoney, countOfManualLotto, lottoTickets);
    }

    public int getCountOfAutoLotto() {
        return this.lottoMoney.calculateCountOfLotto() - getCountOfManualLotto();
    }

    public int getCountOfManualLotto() {
        return this.lottoTickets.size();
    }

    public LottoTickets issued() {
        return LottoTickets.multiIssued(this.getCountOfAutoLotto(), this.lottoTickets);
    }
}
