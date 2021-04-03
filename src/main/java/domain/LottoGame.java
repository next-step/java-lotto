package domain;

import enums.Rank;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGame {

    private Money money;
    private LottoList lottoList;

    public LottoGame(Money money) {
        this.money = money;
        this.lottoList = new LottoList(money.getTicketCount());
        System.out.println(lottoList.toString());
    }

    public List<Rank> findWinners(LottoNumbers winNumbers, BonusNumber bonusNumber){
        return lottoList
            .getLottos()
            .stream()
            .filter(lottoNumbers -> lottoNumbers.isRank(winNumbers.getNumbers()))
            .map(lottoNumbers -> lottoNumbers.convertRank(winNumbers.getNumbers(), bonusNumber))
            .collect(Collectors.toList());
    }

    public LottoResultResponse convert(LottoNumbers winNumbers, BonusNumber bonusNumber){
        List<Rank> ranks = findWinners(winNumbers, bonusNumber);
        double totalWinnings =
            ranks
                .stream()
                .map(Rank::getPrice)
                .reduce(0, Integer::sum);
        double yield = Math.round((totalWinnings / money.getMoney()));
        return new LottoResultResponse(yield, ranks, bonusNumber);
    }
}
