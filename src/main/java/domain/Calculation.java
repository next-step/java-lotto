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

    public Operand calculate() {
        if (operands.size() == 1) {
            return operands.getNext();
        }

        return calculateLoop();
    }

    private Operand calculateLoop() {
        Operand firstOperand = operands.getNext();
        Operand secondOperand = operands.getNext();
        Operator operator = operators.getNext();

        while (operators.hasNext()) {
            firstOperand = operator.operate(firstOperand, secondOperand);
            secondOperand = operands.getNext();
            operator = operators.getNext();
        }

        return operator.operate(firstOperand, secondOperand);
    }

    private void initializeOperatorsAndOperands(Tokens tokens) {
        for (int i = 0; i < tokens.size(); i += 2) {
            addIfValidOperand(tokens, i);
        }

        for (int i = 1; i < tokens.size(); i += 2) {
            addIfValidOperator(tokens, i);
        }

        if (isValidFormula()) {
            throw new IllegalArgumentException("Invalid Formula");
        }
    }

    private boolean isValidFormula() {
        return operands.size() != operators.size() + 1;
    }

    private void addIfValidOperator(Tokens tokens, int i) {
        try {
            operators.add(Operator.of(tokens.getToken(i)));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid Formula");
        }
    }

    private void addIfValidOperand(Tokens tokens, int i) {
        try {
            operands.add(Operand.of(tokens.getToken(i)));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid Formula");
        }
    }
}
