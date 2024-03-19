package domain;

import java.util.List;

public class SeparationDto {
    private final List<Integer>  numbers;
    private final List<String> operators;

    public List<Integer> getNumbers() {
        return numbers;
    }

    public List<String> getOperators() {
        return operators;
    }

    public SeparationDto(List<Integer> numbers, List<String> operators) {
        this.numbers = numbers;
        this.operators = operators;
    }
}
