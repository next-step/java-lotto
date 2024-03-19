package domain;

import java.util.ArrayList;

import static util.NumberUtils.isNumber;

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
        if(!isNumber(first)) throw new IllegalArgumentException();
    }

    private void addToDto(SeparationDto separationDto, String s) {
        if (isNumber(s)) separationDto.getNumbers().add(toInts(s));
        if (!isNumber(s)) separationDto.getOperators().add(s);
    }

    private int toInts(String input) {
        return Integer.parseInt(input);
    }

    private void validateIfDuplication(String input) {
        if (isNumber(input) && previousState) throw new IllegalArgumentException();
        if (!isNumber(input) && !previousState) throw new IllegalArgumentException();
    }
}
