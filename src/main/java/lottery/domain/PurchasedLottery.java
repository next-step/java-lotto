package lottery.domain;


public class PurchasedLottery {

    private static final int NO_MANUAL = 0;

    private static final String EXCEED_AMOUNT_MSG = "로또 구매금액을 초과 하였습니다.";

    private final LotteryPrice lotteryPrice;

    private final ManualQuantity manualQuantity;

    public PurchasedLottery(int purchasedPrice, int manualQuantity) {
        this(new LotteryPrice(purchasedPrice), new ManualQuantity(manualQuantity));
    }

    public PurchasedLottery(int purchasedPrice) {
        this(new LotteryPrice(purchasedPrice), new ManualQuantity(NO_MANUAL));
    }

    public PurchasedLottery(LotteryPrice lotteryPrice,
            ManualQuantity manualQuantity) {
        if(manualQuantity.beyondTheAmount(lotteryPrice.numberOfPlays())) {
            throw new IllegalArgumentException(EXCEED_AMOUNT_MSG);
        }
        this.lotteryPrice = lotteryPrice;
        this.manualQuantity = manualQuantity;
    }

    public int totalPlays() {
        return lotteryPrice.numberOfPlays();
    }

    public int autoPlays() {
        return manualQuantity.autoPlays(lotteryPrice.numberOfPlays());
    }

    public int manualPlays() {
        return manualQuantity.manualPlays();
    }
}
