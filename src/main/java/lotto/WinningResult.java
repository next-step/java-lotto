package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningResult {

    private final Map<Integer, Integer> winningResult = new HashMap<>();

    public Map<Integer, Integer> getWinningResult() {
        return winningResult;
    }

    public WinningResult() {
        init();
    }

    private void init() {
        winningResult.put(3, 0);
        winningResult.put(4, 0);
        winningResult.put(5, 0);
        winningResult.put(6, 0);
    }

    public void calculateWinningResult(Map<Integer, List<Integer>> lottoNumbers, List<Integer> winningNumbers) {
        for (int i = 1; i <= lottoNumbers.size(); i++) {
            List<Integer> lottoNumber = lottoNumbers.get(i);
            int equalNumberCount = countEqualNumbers(lottoNumber, winningNumbers);
            saveWinningResult(equalNumberCount);
        }

    }

    private void saveWinningResult(int equalNumberCount) {
        if (equalNumberCount >= 6) {
            winningResult.put(6, winningResult.getOrDefault(6, 0) + 1);
        } else if (equalNumberCount >= 5) {
            winningResult.put(5, winningResult.getOrDefault(5, 0) + 1);
        } else if (equalNumberCount >= 4) {
            winningResult.put(4, winningResult.getOrDefault(4, 0) + 1);
        } else if (equalNumberCount >= 3) {
            winningResult.put(3, winningResult.getOrDefault(3, 0) + 1);
        }
    }

    private int countEqualNumbers(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        int count = 0;
        for (Integer lottoNumber : lottoNumbers) {
            if (winningNumbers.contains(lottoNumber)) {
                count++;
            }
        }
        return count;
    }


    public Double calculateRateOfReturn(int amount) {
        Double sum = 0.0;
        Double total = 0.0;
        for (int i = WinningPrice.getLastEqualCount(); i <= WinningPrice.getFirstEqualCount(); i++) {
            int count = winningResult.get(i);
            sum += count * WinningPrice.of(i).getPrice();
        }

        total = sum / amount / 100;
        return total;
    }

}
