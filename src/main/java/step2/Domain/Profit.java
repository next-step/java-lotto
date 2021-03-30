package step2.Domain;

public class Profit {

    private Money money;
    private Rank rank;

    public Profit(Money money, Rank rank) {
        this.money = money;
        this.rank = rank;
    }

    public double profitRate() {
        return profitSum() / money.getMoney();
    }

    //refactoring 필요
    public double profitSum() {
        return rank.getRank().keySet()
                .stream()
                .filter(hitCount -> rank.size(hitCount) > 0)
                .mapToDouble(hitCount ->
                        Long.valueOf(LottoPrize.valueOf(hitCount,false).prize()).doubleValue()
                                * rank.size(hitCount))
                .sum();
    }

    //refactoring 필요
//    public double profitSum() {
//        for (int rank = 3; rank <= 6; rank++) {
//            HitCount hitCount = new HitCount(rank);
//            System.out.println(String.format("%d개 일치 (%d)원 - %d개",
//                    rank, LottoPrize.getPrizeInfoByHitCount(hitCount).prize(), ranking.size(hitCount)));
//        }
//        Profit profit = new Profit(purchaseManager, ranking);
//        System.out.println(String.format("총 수익률은 %.2f 입니다.", profit.profitRate()));
//    }

}
