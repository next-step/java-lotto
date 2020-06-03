package step2.domain;

/*

public enum PrizeType {

    PRIZE3(3, (Prize.of(3, 5_000)) {
     ->null);




*/
/*

    PRIZE4(4, (Prize.of(4,5_000)),
    PRIZE5(5, (Prize.of(5,5_000)),
    PRIZE6(6, (Prize.of(6,5_000));

*//*


        public int matchedNumber;
        public int prizePrice;
        public Prize prize;

        PrizeType(Prize prize) {

            this.matchedNumber = prize.getMatchedNumber();
            this.prizePrice = prize.getPrizePrice();
            this.prize = prize;
        }

        static PrizeType of(int matchedNumber) {

            for (PrizeType prizeType : PrizeType.values()) {
                if (prizeType.matchedNumber == matchedNumber) {
                    return prizeType;
                }
            }
            throw new IllegalArgumentException();
        }


    }
*/
