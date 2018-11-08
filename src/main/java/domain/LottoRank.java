package domain;

public enum LottoRank {

    FIRST_PRICE(6 ,2000000000),
    SECOND_PRICE(5,1500000),
    THIRD_PRICE(4,50000),
    FOURTH_PRICE(3 ,5000);
//    FIFTH_PRICE(2 ,0),
//    SIXTH_PRICE(1, 0),
//    SEVENTH_PRICE(0, 0);

    private int combineNum;
    private int priceRewards;
//    private Function<String, Integer> expression;

    LottoRank(int combineNum, int priceRewards){
        this.combineNum = combineNum;
        this.priceRewards = priceRewards;
    }

    public int getCombineNum() {
        return combineNum;
    }

    public int getPriceRewards() {
        return priceRewards;
    }

    public int getPriceRewards(int combineNum) {
        if(this.combineNum == combineNum){
            return priceRewards;
        }
        return 0;
    }

    //    LottoRank(String rank, Function<String, Integer> expression){
//       this.rank = rank;
//       this.expression = expression;
//    }

//    public static LottoRank findByRankRewards(String combineCount){
//        return Arrays.stream(LottoRank.values())
//                .filter( rank -> rank.equalToString(combineCount))
//                .findFirst()
//                .orElse(null);
//    }

//    public Integer rewards(String value){
//        return expression.apply(value);
//    }



}
