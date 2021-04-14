package domain;

import enums.Rank;
import java.util.List;

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

    public LottoResultResponse convert(LottoResultRequest lottoResultRequest){
        List<Rank> ranks = lottoResultRequest.findWinners(lottoList.getLottos());

        double totalWinnings =
            ranks
                .stream()
                .map(Rank::getPrice)
                .reduce(0, Integer::sum);
        double yield = money.calcYield(totalWinnings);
        return new LottoResultResponse(yield, ranks);
    }

}
