package calculator;


public interface Operation {
    int apply(int a, int b);

}

class Plus implements Operation {

    @Override
    public int apply(int a, int b) {
        return a + b;
    }
}

class Minus implements Operation {

    @Override
    public int apply(int a, int b) {
        return a - b;
    }
}

class Multiply implements Operation {

    @Override
    public int apply(int a, int b) {
        return a * b;
    }
}

class Division implements Operation {

    @Override
    public int apply(int a, int b) {
        return a / b;
    }
}
