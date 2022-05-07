package calculator.domain;

public class Calculator {
    private Number frontNumber;
    private Symbol symbol;
    private Number backNumber;

    public Calculator(String frontNumber, String symbol, String backNumber) {
        this(Integer.parseInt(frontNumber), symbol, Integer.parseInt(backNumber));
    }

    public Calculator(int frontNumber, String symbol, String backNumber) {
        this(frontNumber, symbol, Integer.parseInt(backNumber));
    }

    public Calculator(int frontNumber, String symbol, int backNumber) {
        this(new Number(frontNumber), symbol, new Number(backNumber));
    }

    public Calculator(Number frontNumber, String symbol, Number backNumber) {
        this(frontNumber, Symbol.classifySymbol(symbol), backNumber);
    }

    public Calculator(Number frontNumber, Symbol symbol, Number backNumber) {
        this.frontNumber = frontNumber;
        this.symbol = symbol;
        this.backNumber = backNumber;
    }

    public int calculate() {
        switch (symbol) {
            case PLUS:      return frontNumber.getNumber() + backNumber.getNumber();
            case MINUS:     return frontNumber.getNumber() - backNumber.getNumber();
            case MULTIPLY:  return frontNumber.getNumber() * backNumber.getNumber();
            case DIVIDE:    return frontNumber.getNumber() / backNumber.getNumber();
            default:
                throw new IllegalArgumentException("사칙연산 이외의 기호는 입력 할 수 없습니다.");
        }
    }
}
