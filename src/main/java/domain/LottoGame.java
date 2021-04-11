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
        lottoList
            .getLottos()
            .forEach(System.out::println);
        System.out.println();
    }

    public LottoGame(Money money, List<LottoNumbers> stickLottoNumbers) {
        this.money = money;
        this.lottoList = new LottoList(money.getTicketCount());
        lottoList
            .getLottos()
            .forEach(System.out::println);
        this.lottoList.getLottos().addAll(stickLottoNumbers);
        System.out.println();
    }

    public List<Rank> findWinners(LottoNumbers winNumbers, LottoNumber bonusNumber) {
        return lottoList
            .getLottos()
            .stream()
            .filter(lottoNumbers -> lottoNumbers.isRank(winNumbers.getNumbers()))
            .map(lottoNumbers -> lottoNumbers.convertRank(winNumbers.getNumbers(), bonusNumber))
            .collect(Collectors.toList());
    }

    public LottoResultResponse convert(LottoNumbers winNumbers, LottoNumber bonusNumber){
        List<Rank> ranks = findWinners(winNumbers, bonusNumber);

        double totalWinnings =
            ranks
                .stream()
                .map(Rank::getPrice)
                .reduce(0, Integer::sum);
        double yield = money.calcYield(totalWinnings);
        return new LottoResultResponse(yield, ranks);
    }
}
