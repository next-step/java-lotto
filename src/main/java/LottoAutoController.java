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

        WinningResult winningResult = new WinningResult();
        winningResult.getWinningResult(lottos, winningNumbers, bonusNumber);
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


    private float getEarningRate(int price) {
        float floatPrice = (float) price;
        return (WinningPrice.FIFTHPRICE.getPrice() * WinningResult.getNumberOfFifthPlace()
                + WinningPrice.FOURTHPRICE.getPrice() * WinningResult.getNumberOfFourthPlace()
                + WinningPrice.THIRDPRICE.getPrice() * WinningResult.getNumberOfThirdPlace()
                + WinningPrice.SECONDPRICE.getPrice() * WinningResult.getNumberOfSecondPlace()
                + WinningPrice.FIRSTPRICE.getPrice() * WinningResult.getNumberOfFirstPlace()) / floatPrice;
    }
}
