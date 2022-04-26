package calculator.util;

import calculator.model.Symbol;

import java.util.function.BinaryOperator;

public abstract class Operator {

    abstract BinaryOperator<Integer> operate();

    public static BinaryOperator<Integer> operator(Symbol symbol) {
        Operator operator = Addition.getInstance();

        if (symbol.equals(Symbol.SUBTRACTION)) {
            operator = Subtraction.getInstance();
        }

        if (symbol.equals(Symbol.MULTIPLICATION)) {
            operator = Multiplication.getInstance();
        }

        if (symbol.equals(Symbol.DIVISION)) {
            operator = Division.getInstance();
        }

        return operator.operate();
    }

    private static class Addition extends Operator {

        private static Operator addition;

        private Addition() {
        }

        private static Operator getInstance() {
            if (addition == null) {
                addition = new Addition();
            }

            return addition;
        }

        @Override
        BinaryOperator<Integer> operate() {
            return Math::addExact;
        }
    }

    private static class Subtraction extends Operator {

        private static Operator subtraction;

        private Subtraction() {
        }

        private static Operator getInstance() {
            if (subtraction == null) {
                subtraction = new Subtraction();
            }

            return subtraction;
        }

        @Override
        BinaryOperator<Integer> operate() {
            return Math::subtractExact;
        }
    }

    private static class Multiplication extends Operator {

        private static Operator multiplication;

        private Multiplication() {
        }

        private static Operator getInstance() {
            if (multiplication == null) {
                multiplication = new Multiplication();
            }

            return multiplication;
        }

        @Override
        BinaryOperator<Integer> operate() {
            return Math::multiplyExact;
        }
    }

    private static class Division extends Operator {

        private static Operator division;

        private Division() {
        }

        private static Operator getInstance() {
            if (division == null) {
                division = new Division();
            }

            return division;
        }

        @Override
        BinaryOperator<Integer> operate() {
            return Math::floorDiv;
        }
    }
}