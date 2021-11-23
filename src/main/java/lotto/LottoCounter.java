package lotto;

public class LottoCounter {

    private int[] placeCounts = new int[LottoResult.WinningCriteria.values().length];

    public void countResult(int matchCount) {
        placeCounts[LottoResult.WinningCriteria.of(matchCount).idx()]++;
    }

    public LottoResult makeResult() {
        LottoResult result = new LottoResult(placeCounts);
        clear();
        return result;
    }

    private void clear() {
        for (int i = 0; i < placeCounts.length; i++) {
            placeCounts[i] = 0;
        }
    }

}
