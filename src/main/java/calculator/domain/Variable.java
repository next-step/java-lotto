package calculator.domain;

public class Variable {

    private final String string;

    private Variable(String string) {
        this.string = string;
    }

    public static Variable of(String string) {
        return new Variable(string);
    }


    public int value() {
        return Integer.parseInt(string);
    }
}
