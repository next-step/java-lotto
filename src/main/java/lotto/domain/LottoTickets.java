package lotto.domain;

import lotto.infrastructure.AutoLottoNumberStrategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.toList;
import static lotto.domain.Constant.ZERO_INDEX;

public class LottoTickets {
    private final List<LottoTicket> lottoTickets;

    LottoTickets(int gameCount) {
        lottoTickets = buyLottoTickets(gameCount);
    }

    LottoTickets(LottoNumber... lottoNumbers) {
        this.lottoTickets = Arrays.asList(lottoNumbers).stream()
                .map(LottoTicket::new)
                .collect(toList());
    }

    public List<LottoRank> checkRank(WinningNumber winningNumber) {
        return lottoTickets.stream()
                .map(lottoTicket -> lottoTicket.checkPrize(winningNumber))
                .collect(toList());
    }

    public void print() {
        lottoTickets.stream()
                .forEach(System.out::println);
    }

    int size() {
        return lottoTickets.size();
    }

    private List<LottoTicket> buyLottoTickets(int gameCount) {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (int i = ZERO_INDEX; i < gameCount; i++) {
            lottoTickets.add(new LottoTicket(new AutoLottoNumberStrategy()));
        }
        return lottoTickets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoTickets)) return false;
        LottoTickets that = (LottoTickets) o;
        return Objects.equals(lottoTickets, that.lottoTickets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoTickets);
    }

}
