package repository;

import domain.Lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserLottoRepository {
    private List<Lotto> lottoTickets = new ArrayList<>();

    public UserLottoRepository() {
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
