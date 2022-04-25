package string_calculator;

import java.util.Objects;

public class Integer implements Value  {
    private final int value;

    public Integer(int i) {
        this.value = i;
    }

    public int value() {
        return this.value;
    }

    @Override
    public String toString() {
        return "Integer{" +
                "value=" + value +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Integer integer = (Integer) o;
        return value == integer.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

//    public Integer plus(Integer operand) {
//        return new Integer(this.value + operand.value);
//    }
//
//    public Integer minus(Integer operand) {
//        return new Integer(this.value - operand.value);
//    }
//
//    public Integer multiply(Integer operand) {
//        return new Integer(this.value * operand.value);
//    }
//
//    public Integer divide(Integer operand) {
//        if (operand.value == 0) {
//            throw new ArithmeticException("Can't divide by Zero.");
//        }
//        Boolean isDividable =  this.modulo(operand).value == 0;
//        if (isDividable) {
//            return new Integer(this.value / operand.value);
//        }
//        throw new IllegalArgumentException("Can't divide.");
//    }
//
//    public Integer modulo(Integer operand) {
//        return new Integer(this.value % operand.value);
//    }

    public void print(Integer payload) {
        System.out.printf("Result: %d\n", payload.value);
    }
}
