package lotto.domain;

import lotto.util.NumberUtil;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lotto {

    private final static int size = 6;
    private List<Integer> numbers;

    public Lotto() {
        numbers = new ArrayList<>();
    }

    public Lotto createLotto() {
        selectedNumber(generateRandomNumbers());
        return this;
    }

    public int numberOfLottoCount(){
        return this.numbers.size();
    }

    private List<Integer> generateRandomNumbers() {
        List<Integer> randomNumbers = NumberUtil.getLottoNumbers();

        Collections.shuffle(randomNumbers);

        List<Integer> lottoNumbers = new ArrayList<>();

        randomNumbers.subList(0, size).stream()
                .forEach(lottoNumbers::add);
        return lottoNumbers;
    }

    protected Lotto selectedNumber(List<Integer> randomNumbers) {
        this.numbers = randomNumbers;
        return this;
    }


    public int checkLastWinningNumber(String lastWinnerNumber) {
        int matchNumber = 0;
        List<Integer> winnerNumbers = NumberUtil.convertStringToIntegerList(lastWinnerNumber);

        List<Integer> sortedNumbers = new ArrayList<>(this.numbers).stream()
                .sorted().collect(Collectors.toList());

        for( int i = 0; i < winnerNumbers.size(); i++) {
            if(sortedNumbers.get(i).equals( winnerNumbers.get(i))) {
                matchNumber = matchNumber + 1;
            }
        }
        return matchNumber;
    }
    public boolean checkBonusNumber( BonusNumber bonusNumber){
        Optional<Integer> matchedBonusNumber = this.numbers.stream()
                .filter((number) -> bonusNumber.equals(number)).findFirst();
        return matchedBonusNumber.isPresent();
    }

    public List<Integer> showLottoNumber(){
        return new ArrayList<>(this.numbers);
    }

}
