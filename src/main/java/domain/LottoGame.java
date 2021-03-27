package domain;

import enums.Rank;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGame {

    private static final int LOTTO_TICKET_PRICE = 1000;
    private int monkey;
    private LottoList lottoList;
    private LottoNumbers winNumbers;

    public LottoGame(int monkey, LottoNumbers winNumbers) {
        this.monkey = monkey;
        int ticketCount = monkey / LOTTO_TICKET_PRICE;
        lottoList = new LottoList(ticketCount);
        this.winNumbers = winNumbers;

        List<Rank> ranks = findWinners();
        System.out.println("3개 일치 (5000원)- "+ranks.stream().filter(rank-> rank == Rank.THIRD_PLACE).count());
        System.out.println("4개 일치 (5000원)- "+ranks.stream().filter(rank-> rank == Rank.FOUR_PLACE).count());
        System.out.println("5개 일치 (5000원)- "+ranks.stream().filter(rank-> rank == Rank.SECOND_PLACE).count());
        System.out.println("6개 일치 (5000원)- "+ranks.stream().filter(rank-> rank == Rank.FIRST_PLACE).count());

        int totalWinnings =
            ranks
                .stream()
                .map(Rank::getPrice)
                .reduce(0, Integer::sum);

        System.out.println("총 수익률은"+ totalWinnings /monkey);
    }

    public List<Rank> findWinners(){
        return lottoList
            .getLottos()
            .stream()
            .filter(lottoNumbers -> lottoNumbers.isRank(winNumbers.getNumbers()))
            .map(lottoNumbers -> lottoNumbers.convertRank(winNumbers.getNumbers()))
            .collect(Collectors.toList());
    }
}
