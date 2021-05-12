import java.util.ArrayList;
import java.util.List;

public class LottoAutoController {

    public void start() {
        LottoAutoView view = new LottoAutoView();

        int price = view.inputPrice();
        int quantity = price / 1000;

        List<LottoAutoModel> lottos = new ArrayList<>();
        setLotto(quantity, lottos);
        view.printLotto(quantity, lottos);

        List<Integer> winningNumbers = convertWinningNumbersToInt(view.inputWinningNumbers());
        int bonusNumber = convertBonusNumberToInt(view.inputBonusNumber());

        getWinningResult(lottos, winningNumbers, bonusNumber);
        view.outputWinningStatistic(getEarningRate(price));
    }

    public void setLotto(int quantity, List<LottoAutoModel> lottos) {
        for (int i = 0; i < quantity; i++) {
            lottos.add(new LottoAutoModel());
        }
    }

    public List<Integer> convertWinningNumbersToInt(String winningStringNumbers) {
        List<Integer> winningNumbers = new ArrayList<>();
        String[] splitWinningNumbers = winningStringNumbers.split(", ");
        for (int i = 0; i < splitWinningNumbers.length; i++) {
            int number = Integer.parseInt(splitWinningNumbers[i]);
            winningNumbers.add(number);
        }
        return winningNumbers;
    }

    private int convertBonusNumberToInt(String bonusStringNumber) {
        int bonusNumber = Integer.parseInt(bonusStringNumber);
        return bonusNumber;
    }

    enum winningResult {
        fifth(5000, 0),
        fourth(50000, 0),
        third(1500000, 0),
        second(30000000, 0),
        first(2000000000, 0);

        int winningPrice;
        int numberOfWinnings;

        winningResult(int winningPrice, int numberOfWinnings) {
            this.winningPrice = winningPrice;
            this.numberOfWinnings = numberOfWinnings;
        }

        public int getWinningPrice() {
            return winningPrice;
        }

        public int getNumberOfWinnings() {
            return numberOfWinnings;
        }

        public static void addCount(int count, boolean bonus) {
            if (count == 3) {
                winningResult.fifth.numberOfWinnings++;
            }
            if (count == 4) {
                winningResult.fourth.numberOfWinnings++;
            }
            if (count == 5 && !bonus) {
                winningResult.third.numberOfWinnings++;
            }
            if (count == 5 && bonus) {
                winningResult.second.numberOfWinnings++;
            }
            if (count == 6) {
                winningResult.first.numberOfWinnings++;
            }
        }
    }

    private void getWinningResult(List<LottoAutoModel> lottos, List<Integer> winningNumbers, int bonusNumber) {
        for (LottoAutoModel lotto : lottos) {
            int count = lotto.setWinningResult(winningNumbers);
            boolean bonus = lotto.getAutoNumbers().contains(bonusNumber);
            winningResult.addCount(count, bonus);
        }
    }

    private float getEarningRate(int price) {
        float floatPrice = (float) price;
        return (winningResult.fifth.getWinningPrice() * winningResult.fifth.getNumberOfWinnings()
                + winningResult.fourth.getWinningPrice() * winningResult.fourth.getNumberOfWinnings()
                + winningResult.third.getWinningPrice() * winningResult.third.getNumberOfWinnings()
                + winningResult.second.getWinningPrice() * winningResult.second.getNumberOfWinnings()
                + winningResult.first.getWinningPrice() * winningResult.first.getNumberOfWinnings()) / floatPrice;
    }
}
