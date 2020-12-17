package lotto.domain;

import lotto.util.NumberUtil;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lotto {

    private List<Integer> numbers;

    public Lotto() {
        numbers = new ArrayList<>();
    }

    public int generateNumbers() {
        List<Integer> lottoNumbers = NumberUtil.generatelottoNumberSet();

        Collections.shuffle(lottoNumbers);

        for( int i = 0; i < 6; i++ ) {
            this.numbers.add(lottoNumbers.get(i));
        }
        Collections.sort(numbers);
        return this.numbers.size();
    }

    @Override
    public String toString() {
        String lottoNumbers = this.numbers.stream()
                                    .map(String::valueOf)
                                    .collect(Collectors.joining(","));
        return "[" + lottoNumbers + "]";
    }

    /**
     *  matching Test를 위해서 만듬
     */
    protected void createNumber( List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int checkLastWinningNumber(String lastWinnerNumber) {
        int matchNumber = 0;
        List<Integer> winnerNumbers = Arrays.stream(
                                            lastWinnerNumber.split(","))
                                            .map(Integer::new)
                                            .sorted()
                                            .collect(Collectors.toList());
        for( int i = 0; i < winnerNumbers.size(); i++) {
            if(this.numbers.get(i).equals( winnerNumbers.get(i))) {
                matchNumber = matchNumber + 1;
            }
        }
        return matchNumber;
    }
}
