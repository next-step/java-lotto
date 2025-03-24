package domain;

import domain.symbol.Operand;
import domain.symbol.Operator;
import domain.symbol.SymbolSequence;

public class Calculation {

    private final SymbolSequence<Operand> operands;
    private final SymbolSequence<Operator> operators;

    public Calculation(Tokens tokens) {
        this.operands = new SymbolSequence<>();
        this.operators = new SymbolSequence<>();
        initializeOperatorsAndOperands(tokens);
    }

    private void initializeOperatorsAndOperands(Tokens tokens) {
        for (int i = 0; i < tokens.size(); i += 2) {
            operands.add(Operand.of(tokens.getToken(i)));
        }

        for (int i = 1; i < tokens.size(); i += 2) {
            operators.add(Operator.of(tokens.getToken(i)));
        }
    }

    public Operand calculate() {
        Operand firstOperand = operands.getNext();
        Operand secondOperand = operands.getNext();
        Operator operator = operators.getNext();

        while (operators.hasNext()) {
            firstOperand = operator.operate(firstOperand, secondOperand);
            operator = operators.getNext();
            secondOperand = operands.getNext();
        }

        return operator.operate(firstOperand, secondOperand);
    }
}
