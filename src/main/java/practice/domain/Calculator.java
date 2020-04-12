package practice.domain;

import practice.vo.Elements;

public final class Calculator {

    private Calculator() { }

    public static int Sum(final String formula) {

        int result = 0;

        Elements elements = new Elements(formula);
        for (int elm : elements.getElements()) {
            result += elm;
        }

        return result;
    }
}
