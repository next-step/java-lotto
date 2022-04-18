package me.devyonghee.calculator;

final class CalculatorFactory {

    private CalculatorFactory() {
        throw new AssertionError();
    }

    static Calculator calculator(Operation operation, Calculator calculator, Number number) {
        Assert.notNull(operation, "operation must not be null");
        if (operation.isPlus()) {
            return PlusCalculator.of(calculator, number);
        }
        if (operation.isMinus()) {
            return MinusCalculator.of(calculator, number);
        }
        if (operation.isDivide()) {
            return DivideCalculator.of(calculator, number);
        }
        if (operation.isMultiply()) {
            return MultiplyCalculator.of(calculator, number);
        }
        throw new IllegalArgumentException(String.format("calculator of operation(%s) type is not exist", operation));
    }
}
