import java.util.List;

public class LottoResult {
    private static final int[] REWARD = {0, 0, 0, 5000, 50000, 1500000, 2000000000};
    private final double totalPrice;
    private int[] matchNumber = new int[7];

    public LottoResult(List<List<Integer>> selectedLottoNumbers, int[] winningNumbers) {
        totalPrice = selectedLottoNumbers.size() * LottoMachine.LOTTO_PRICE;

        for (int i = 0; i < selectedLottoNumbers.size(); i++) {
            int match = 0;
            for (int number : winningNumbers) {
                if (selectedLottoNumbers.get(i).contains(number)) {
                    match++;
                }
            }
            matchNumber[match]++;
        }
    }

    public double getProfit() {
        double sum = 0;
        for (int i = 3; i <= 6; i++) {
            sum += (matchNumber[i] * REWARD[i]);
        }
        return Math.floor(sum / totalPrice * 100) / 100.0;
    }

    public int getMatchNumber(int number) {
        return matchNumber[number];
    }
}
