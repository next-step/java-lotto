package step2.Domain;

public class Profit {

//    private PurchaseManager manager;
//    private Rank rank;
//
//    public Profit(PurchaseManager manager, Rank rank) {
//        this.manager = manager;
//        this.rank = rank;
//    }
//
//    public double profitRate() {
//        return profitSum() / manager.money().getMoney();
//    }
//
//    //refactoring 필요
//    public double profitSum() {
//        return rank.getRank().keySet()
//                .stream()
//                .filter(hitCount -> rank.size(hitCount) > 0)
//                .mapToDouble(hitCount ->
//                        Long.valueOf(LottoPrize.valueOf(hitCount,false).prize()).doubleValue()
//                                * rank.size(hitCount))
//                .sum();
//    }
}
