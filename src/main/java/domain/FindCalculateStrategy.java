package domain;

import java.util.List;

import exception.NotAValidInputException;

public class FindCalculateStrategy {

    private final List<Calculator> calculateList;

    public FindCalculateStrategy(List<Calculator> calculateList) {
        this.calculateList = calculateList;
    }

    public Calculator findCalculate(String symbol) {

        return calculateList.stream()
            .filter(strategy -> strategy.findMatchSymbol(symbol))
            .findAny()
            .orElseThrow(() -> new NotAValidInputException("맞는 사칙기호가 없습니다"));
    }
}
