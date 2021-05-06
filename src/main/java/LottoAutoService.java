import java.util.*;

public class LottoAutoService {

    private int price;
    private int quantity;

    private List<Integer> rangeOfNumbers = new ArrayList<>();
    private List<List> lottoAutoNumbers = new ArrayList<>();

    private List<Integer> convertWinningNumbers;
    private int convertBonusNumber;

    List<Integer> winningResult;
    double earningRate;

    enum winningResult {

    }

    List<Integer> countList;
    List<Integer> bonusList;


    public LottoAutoService(int price, int quantity) {
        this.price = price;
        this.quantity = quantity;
    }

    private void setRangeOfNumbers() {
        for (int i = 0; i < 45; i++) {
            rangeOfNumbers.add(i + 1);
        }
    }

    public List<List> setLottoAutoNumbers() {
        List<Integer> selectNumber = new ArrayList<>();

        Collections.shuffle(rangeOfNumbers);
        for (int i = 0; i < 6; i++) {
            selectNumber.add(rangeOfNumbers.get(i));
        }

        Collections.sort(selectNumber);
        for (int i = 0; i < quantity; i++) {
            lottoAutoNumbers.add(selectNumber);
        }
        return lottoAutoNumbers;
    }

    public void setWinningNumbers(String winningNumbers) {
        String[] splitWinningNumbers = winningNumbers.split(",");
        for (int i = 0; i < splitWinningNumbers.length; i++) {
            int number = Integer.parseInt(splitWinningNumbers[i]);
            convertWinningNumbers.add(number);
        }
    }

    public void setBonusNumber(String bonusNumber) {
        convertBonusNumber = Integer.parseInt(bonusNumber);
    }

    public List<Integer> statistic(List<List> result, List<Integer> winningNum) {

        countList = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            int count = 0;
            for (int j = 0; j < winningNum.size(); j++) {
                if (result.get(i).contains(winningNum.get(j))) {
                    count++;

                }
            }
            countList.add(count);
        }
        return countList;

    }

    public List<Integer> statisticBonus(List<List> result, int bonus) {
        bonusList = new ArrayList<>();

        for (int i = 0; i < result.size(); i++) {
            int count = 0;
            for (int j = 0; j < countList.size(); j++) {
                if (countList.get(j) == 5 && result.get(i).contains(bonus)) {
                    countList.remove(j);
                    j--;
                }
                bonusList.add(count);
            }
        }
        return bonusList;
    }

    public List<Integer> collectWinningResult() {

        for (int i = 0; i < lottoAutoNumbers.size(); i++) {
            int count = 0;
            for (int j = 0; j < convertWinningNumbers.size(); j++) {
                if (lottoAutoNumbers.get(i).contains(convertWinningNumbers.get(j))) {
                    count++;
                }
            }
            if (count == 3) {
                winningResult.add(0);
                //winningResult[0]++;
            }
            if (count == 4) {

            }
            if (count == 5) {

            }
            if (count == 6) {

            }
        }
        return winningResult;
    }

    public double setEarningRate() {
        earningRate = (5000 * winningResult.get(0) + 50000 * winningResult.get(1) + 1500000 * winningResult.get(2) + 30000000 * winningResult.get(3) + 2000000000 * winningResult.get(4)) / price;
        return earningRate;
    }
}
