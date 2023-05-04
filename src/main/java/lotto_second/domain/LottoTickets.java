package lotto_second.domain;

import lotto_second.service.LottoResult;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {
    private final List<Lotto> lottoTickets;
    private LottoWinner lottoWinner;

    public LottoTickets(List<Lotto> lottoTickets) {
        this.lottoTickets = new ArrayList<>(lottoTickets);
    }

    public void add(LottoTickets other) {
        lottoTickets.addAll(other.getLottoTickets());
    }

    public List<Lotto> getLottoTickets() {
        return lottoTickets;
    }

    public int size() {
        return lottoTickets.size();
    }

    public Lotto get(int index) {
        return lottoTickets.get(index);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoTickets that = (LottoTickets) o;
        List<Lotto> thatLottoTickets = that.getLottoTickets();

        if (lottoTickets.size() != thatLottoTickets.size()) {
            return false;
        }

        for (int i = 0; i < lottoTickets.size(); i++) {
            List<LottoNumber> thisNumbers = lottoTickets.get(i).getNumbers();
            List<LottoNumber> thatNumbers = thatLottoTickets.get(i).getNumbers();

            if (!thisNumbers.equals(thatNumbers)) {
                return false;
            }
        }

        return true;
    }

    public LottoResult calculateResult(LottoWinner lottoWinner) {
        LottoResult lottoResult = new LottoResult();
        lottoResult.calculateResult(this.lottoTickets, lottoWinner);
        return lottoResult;
    }
}
