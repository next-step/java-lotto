package domain.lotto;

import java.util.ArrayList;
import java.util.List;

public class ComparisonLottoNumber {
    private List<Integer> resultCount = new ArrayList<>();
    private List<Integer> winningNumber = new ArrayList<>();

    public List<Integer> comparison(AllLotto allLotto, String winning_numbers, int bonus_number) {
        String[] winning_number = winning_numbers.split(",");
        inputWinningNumber(winning_number);
        allLotto.lottoPapers.forEach(lotto -> {
            int matchCount = matchCondition(lotto);
            boolean isContainBonus = false;
            if (matchCount == 5) {
                isContainBonus = fifthIsBonus(lotto, bonus_number);
            }
            if (isContainBonus) {
                matchCount += 2;
            }
            resultCount.add(matchCount);
            System.out.println(resultCount);
        });

        return resultCount;
    }

    private boolean fifthIsBonus(List<Integer> lotto, int bonus_number) {
        for (Integer integer : lotto) {
            return lotto.contains(bonus_number);
        }
        return false;
    }


    private void inputWinningNumber(String[] winning_number) {
        for (int i = 0; i < winning_number.length; i++) {
            winningNumber.add(Integer.valueOf(winning_number[i]));
        }
    }

    private int matchCondition(List<Integer> lotto) {
        int matchCount = (int) winningNumber.stream().filter(lotto::contains).count();
        return matchCount;
    }

}
