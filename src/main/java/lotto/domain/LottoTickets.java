package lotto.domain;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTickets implements Cloneable {

    private  List<LottoTicket> lottoTickets = new LinkedList<>();

    public LottoTickets() {
    }

    public LottoTickets(List<List<Integer>> lottoNumbersList) {
        lottoTickets = lottoNumbersList.stream()
            .map(LottoTicket::create)
            .collect(Collectors.toList());
    }

    public LottoTickets(LottoTickets lottoTickets) {
        lottoTickets.getLottoTickets()
            .forEach(this.lottoTickets::add);
    }

    @Override
    public LottoTickets clone() {
        return new LottoTickets(this);
    }

    public void add() {
        lottoTickets.add(LottoTicket.create());
    }

    public void add(LottoTicket lottoTicket) {
        lottoTickets.add(lottoTicket);
    }

    public int count() {
        return lottoTickets.size();
    }

    public List<LottoResult> findLottoResult(List<Integer> winLottoNumber, int bonusNumber) {
        List<LottoResult> lottoResults = new LinkedList<>();

        for (LottoTicket lottoTicket : lottoTickets) {
            lottoResults.add(lottoTicket.checkLottery(winLottoNumber, bonusNumber));
        }

        return lottoResults;
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }

    @Override
    public String toString() {
        return "LottoTickets{" +
            "lottoTickets=" + lottoTickets +
            '}';
    }

    public int size() {
        return lottoTickets.size();
    }

}
