package service;

import java.util.Deque;
import java.util.List;

import domain.FindCalculateStrategy;
import exception.NotAValidInputException;

public class CalculateCurrentElements {

    private static final String FOUR_RULES_SYMBOLS = "[\\+\\*\\/\\-]";
    private final FindCalculateStrategy findCalculateStrategy;

    public CalculateCurrentElements(FindCalculateStrategy findCalculateStrategy) {
        this.findCalculateStrategy = findCalculateStrategy;
    }

    public Deque<String> calculateElements(List<String> currentElements, Deque<String> pendingElements) {

        if (currentElements.size() == 3) {
            String result = findCalculateSymbol(currentElements);
            pendingElements.addFirst(result);
        }
        return pendingElements;
    }

    private String findCalculateSymbol(List<String> calList) {
        String symbols = calList.stream()
            .filter(it -> it.matches(FOUR_RULES_SYMBOLS))
            .findAny()
            .orElseThrow(() -> new NotAValidInputException("해당하는 사칙기호가 없습니다"));
        return findStrategyAndCalculate(symbols, calList);
    }

    private String findStrategyAndCalculate(String symbols, List<String> calList) {
        Integer result = findCalculateStrategy
            .findCalculate(symbols)
            .calculateWithSymbol(stringToInteger(calList.get(0)), stringToInteger(calList.get(2)));
        return String.valueOf(result);
    }

    private int stringToInteger(String stringNumber) {
        return Integer.parseInt(stringNumber);
    }

}
