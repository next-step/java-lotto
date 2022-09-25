package lotto.step2.domain;

import lotto.step2.domain.dto.WinsNumbersDTO;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class WinsNumbers {
    private static final String WINS_NUMBERS_PRINT_FORMAT = "%d개 일치 (%d원) - %d개";
    private static final int THREE_MATCH_REWARD = 5000;
    private static final int FOUR_MATCH_REWARD = 50000;
    private static final int FIVE_MATCH_REWARD = 1_500_000;
    private static final int SIX_MATCH_REWARD = 2_000_000_000;
    private static final int WINNING_MIN_MATCH_NUMBER = 3;
    
    private final int[] winsNumbers;
    
    public WinsNumbers(int[] winsNumbers) {
        this.winsNumbers = winsNumbers;
    }
    
    public WinsNumbersDTO winsNumbersInformation() {
        return new WinsNumbersDTO(this);
    }
    
    public int[] getWinsNumbers() {
        return winsNumbers;
    }
    
    private int[] getWinnerPrices() {
        return new int[]{THREE_MATCH_REWARD, FOUR_MATCH_REWARD, FIVE_MATCH_REWARD, SIX_MATCH_REWARD};
    }
    
    @Override
    public String toString() {
        return IntStream.range(0, winsNumbers.length)
                .mapToObj(index -> String.format(WINS_NUMBERS_PRINT_FORMAT, index + WINNING_MIN_MATCH_NUMBER, getWinnerPrices()[index], winsNumbers[index]))
                .collect(Collectors.joining("\n"));
    }
}
