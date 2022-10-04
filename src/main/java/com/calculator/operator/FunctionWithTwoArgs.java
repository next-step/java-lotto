package com.calculator.operator;

@FunctionalInterface
interface FunctionWithTwoArgs<One, Two, Three> {
    Three apply(One one, Two two);
}