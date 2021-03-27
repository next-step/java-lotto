package domain;

import enums.Rank;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGame {

    private static final int LOTTO_TICKET_PRICE = 1000;
    private int monkey;
    private LottoList lottoList;
    private LottoNumbers winNumbers;

    public LottoGame(int monkey) {
        this.monkey = monkey;
        int ticketCount = monkey / LOTTO_TICKET_PRICE;
        lottoList = new LottoList(ticketCount);
    }

    public List<Rank> findWinners(){
        return lottoList
            .getLottos()
            .stream()
            .filter(lottoNumbers -> lottoNumbers.isRank(winNumbers.getNumbers()))
            .map(lottoNumbers -> lottoNumbers.convertRank(winNumbers.getNumbers()))
            .collect(Collectors.toList());
    }

    public LottoResultResponse convert(LottoNumbers winNumbers){
        this.winNumbers = winNumbers;
        List<Rank> ranks = findWinners();
        int totalWinnings =
            ranks
                .stream()
                .map(Rank::getPrice)
                .reduce(0, Integer::sum);
        double yield = Math.round((totalWinnings / monkey));
        return new LottoResultResponse(yield, ranks);
    }
}
