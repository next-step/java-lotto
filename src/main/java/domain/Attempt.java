package domain;

import java.util.ArrayList;
import java.util.List;

import static domain.Rank.*;

public class Attempt {

    private List<Integer> numbers;
    private Rank rank;

    public Attempt(List<Integer> numbers, Rank rank) {
        this.numbers = numbers;
        this.rank = rank;
    }

    public Attempt(NumberGenerator numberGenerator) {
        this.numbers = generateAttemptNumbers(numberGenerator);
    }

    private List<Integer> generateAttemptNumbers(NumberGenerator numberGenerator) {
        return numberGenerator.getRandomNumber();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Rank getRank() {
        return rank;
    }

    public void calculateRank(List<Integer> numbers, int bonusNumber){
        setRank(calculateMatchCount(numbers), isExistBonusNumber(bonusNumber));
    }

    public int calculateMatchCount(List<Integer> winnerNumbers) {
        return calculateMatchNumbers(winnerNumbers).size();
    }

    private List<Integer> calculateMatchNumbers(List<Integer> winnerNumbers) {
        List<Integer> matchNumbers = new ArrayList<>();

        for (Integer number : numbers) {
            if (winnerNumbers.contains(number)) {
                matchNumbers.add(number);
            }
        }
        return matchNumbers;
    }

    private boolean isExistBonusNumber(int numbers) {
        return this.numbers.contains(numbers);
    }

    public void setRank(int matchCount, boolean bonusYn) {
        this.rank = findRankBy(matchCount, bonusYn);
    }

}
