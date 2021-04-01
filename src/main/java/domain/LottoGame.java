package domain;

import enums.Rank;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGame {

    private static final int LOTTO_TICKET_PRICE = 1000;
    private int money;
    private LottoList lottoList;

    public LottoGame(int money) {
        this.money = money;
        int ticketCount = money / LOTTO_TICKET_PRICE;
        this.lottoList = new LottoList(ticketCount);
    }

    public LottoGame(int money, LottoList lottoList){
        this.money = money;
        this.lottoList = lottoList;
    }

    public List<Rank> findWinners(LottoNumbers winNumbers){
        return lottoList
            .getLottos()
            .stream()
            .filter(lottoNumbers -> lottoNumbers.isRank(winNumbers.getNumbers()))
            .map(lottoNumbers -> lottoNumbers.convertRank(winNumbers.getNumbers()))
            .collect(Collectors.toList());
    }

    public LottoResultResponse convert(LottoNumbers winNumbers){
        List<Rank> ranks = findWinners(winNumbers);
        int totalWinnings =
            ranks
                .stream()
                .map(Rank::getPrice)
                .reduce(0, Integer::sum);
        double yield = Math.round((totalWinnings / money));
        return new LottoResultResponse(yield, ranks);
    }
}
