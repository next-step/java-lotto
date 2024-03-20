package calculate.domain;

import calculate.util.NumberUtils;

import java.util.ArrayList;

public class Separation {

    private boolean previousState = true;

    public SeparationDto separate(String[] splitInput){
        checkFirstIsNotOperator(splitInput[0]);
        SeparationDto separationDto = new SeparationDto(new ArrayList<>(), new ArrayList<>());
        for (String s : splitInput) {
            addToDto(separationDto, s);
            validateIfDuplication(s);
            previousState = !previousState;
        }
        return separationDto;
    }

    private void checkFirstIsNotOperator(String first) {
        if(!NumberUtils.isNumber(first)) throw new IllegalArgumentException();
    }

    private void addToDto(SeparationDto separationDto, String s) {
        if (NumberUtils.isNumber(s)) separationDto.getNumbers().add(toInts(s));
        if (!NumberUtils.isNumber(s)) separationDto.getOperators().add(s);
    }

    private int toInts(String input) {
        return Integer.parseInt(input);
    }

    private void validateIfDuplication(String input) {
        if (NumberUtils.isNumber(input) && previousState) throw new IllegalArgumentException();
        if (!NumberUtils.isNumber(input) && !previousState) throw new IllegalArgumentException();
    }
}
