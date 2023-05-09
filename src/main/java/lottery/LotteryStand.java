package lottery;

import java.util.ArrayList;
import java.util.List;

public class LotteryStand {
    public static final Integer PRICE = 1000;
    public List<Lottery> buyLotteriesOfAmount(Integer amount) {
        var quantity = amount / PRICE;
        return issueLotteries(quantity);
    }

    private List<Lottery> issueLotteries(Integer quantity) {
        List<Lottery> lotteries = new ArrayList<>();
        for (var i = 0; i < quantity; i++) {
            lotteries.add(new Lottery(LotteryRow.fromRandom()));
        }
        return lotteries;
    }
}
