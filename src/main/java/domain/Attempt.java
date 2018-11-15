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

    public void calculateRank(List<Integer> numbers){
        setRank(calculateMatchCount(numbers));
    }

    public int calculateMatchCount(List<Integer> numbers) {
        List<Integer> attemptNumbers = new ArrayList<>();
        attemptNumbers.addAll(this.numbers);

        List<Integer> winnerNumbers = new ArrayList<>();
        winnerNumbers.addAll(numbers);
        winnerNumbers.retainAll(attemptNumbers);

        return winnerNumbers.size();
    }

    public void setRank(int matchCount) {
        this.rank = findRankBy(matchCount);
    }

}
