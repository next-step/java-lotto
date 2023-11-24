package repository;

import domain.Lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserLottoRepository {
    private List<Lotto> lottoTickets = new ArrayList<>();

    public UserLottoRepository() {
    }

    public UserLottoRepository(Lotto lotto) {
        this.lottoTickets = Arrays.asList(lotto);
    }

    public UserLottoRepository(List<Lotto> lotto) {
        this.lottoTickets = lotto;
    }

    public void saveUserLottoTickets(Lotto lottoTicket) {
        lottoTickets.add(lottoTicket);
    }

    public List<Lotto> getUserLottoTickets() {
        return lottoTickets;
    }

    public void clearStore() {
        lottoTickets.clear();
    }

}
