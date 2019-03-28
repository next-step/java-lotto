package lottery.domain;

import java.util.ArrayList;
import java.util.List;

public class ManualGenerator implements LotteriesGenerator{
    private List<List<Integer>> manualInputNumbers;

    public ManualGenerator(List<List<Integer>> manualNumbers, Money money) {
        checkSize(manualNumbers, money);
        this.manualInputNumbers = manualNumbers;
    }

    private void checkSize(List<List<Integer>> manualNumbers, Money money) {
        if(money.manualCount() != manualNumbers.size()) {
            throw new IllegalArgumentException("수동 개수만큼의 로또용지를 체크해주세요!");
        }
    }

    @Override
    public List<Lottery> generate() {
        List<Lottery> manualLotteries = new ArrayList<>();
        for (List<Integer> manualNumber : manualInputNumbers) {
            manualLotteries.add(new Lottery(manualNumber));
        }
        return manualLotteries;
    }
}
