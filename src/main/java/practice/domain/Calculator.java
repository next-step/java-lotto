package practice.domain;

import practice.vo.Elements;

public final class Calculator {

    public int sum(final String formula) {
        return new Elements(formula).sum();
    }
}
