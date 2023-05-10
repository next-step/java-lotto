package lottery.domain;


public class PurchasedLottery {

    private static final int NO_MANUAL = 0;

    private static final String EXCEED_AMOUNT_MSG = "로또 구매금액을 초과 하였습니다.";

    private final LotteryPurchasedPrice lotteryPurchasedPrice;

    private final ManualQuantity manualQuantity;

    public PurchasedLottery(int purchasedPrice, int manualQuantity) {
        this(new LotteryPurchasedPrice(purchasedPrice), new ManualQuantity(manualQuantity));
    }

    public PurchasedLottery(int purchasedPrice) {
        this(new LotteryPurchasedPrice(purchasedPrice), new ManualQuantity(NO_MANUAL));
    }

    public PurchasedLottery(LotteryPurchasedPrice lotteryPurchasedPrice,
            ManualQuantity manualQuantity) {
        if(manualQuantity.beyondTheAmount(lotteryPurchasedPrice.numberOfPlays())) {
            throw new IllegalArgumentException(EXCEED_AMOUNT_MSG);
        }
        this.lotteryPurchasedPrice = lotteryPurchasedPrice;
        this.manualQuantity = manualQuantity;
    }

    public int totalPlays() {
        return lotteryPurchasedPrice.numberOfPlays();
    }

    public int autoPlays() {
        return manualQuantity.autoPlays(lotteryPurchasedPrice.numberOfPlays());
    }

    public int manualPlays() {
        return manualQuantity.manualPlays();
    }
}
