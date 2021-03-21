package lottery.dto;

import java.util.List;

public class LotteryNumbersDto {

    private final List<Integer> numbers;

    public LotteryNumbersDto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}

