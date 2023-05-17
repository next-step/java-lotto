package lottery;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LotteryCredit {
    private int balance = 0;
    public void chargeWithCash(Natural amount){
        balance += amount.value() / Lottery.PRICE;
    }
    public Natural getBalance(){
        return new Natural(balance);
    }
    public List<Lottery> buyLotteries(List<LotteryRow> rows) {
        return rows.stream()
                .map(this::buyLottery)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }

    public List<Lottery> buyLotteriesAuto(Natural quantity) {
        return IntStream.range(0, quantity.value())
                .mapToObj( i -> buyLottery(LotteryRow.fromRandom()))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }

    private Optional<Lottery> buyLottery(LotteryRow row) {
        if (balance <= 0) {
            return Optional.empty();
        }
        balance--;
        return Optional.of(new Lottery(row));
    }
}
