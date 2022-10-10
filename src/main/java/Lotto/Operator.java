package Lotto;

public abstract class Operator {
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "Operator{}";
    }

    abstract int operate(int num1, int num2);

    static Operator operatorOf(String value) {
        if (value.equals("+")) return new Add();
        return null;
    }
}
