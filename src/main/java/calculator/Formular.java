package calculator;

import org.junit.platform.commons.util.StringUtils;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Formular {
    private final static String FORMULAR_PATTERN = "^[0-9]*( [+|\\-|*|/] [0-9]*)*$";
    private final static String OPERATOR_PATTERN = "[+|\\-|*|/]";
    private final static String NUMBER_PATTERN = "[0-9]";


    private Queue<Operand> operands;
    private Queue<Operator> operators;

    public Formular(String inputString) {
        if (StringUtils.isBlank(inputString)) {
            throw new IllegalArgumentException("산식이 입력 되지 않았습니다.");
        }
        validate(inputString);

        initialize(inputString);
    }

    protected void validate(String inputString) {
        Pattern pattern = Pattern.compile(FORMULAR_PATTERN);
        Matcher mt = pattern.matcher(inputString);
        if (mt.matches()) {
            return;
        }
        throw new IllegalArgumentException("산식이 잘 못 입력 되었습니다");
    }

    private void initialize(String rawFormular) {
        String formularWithoutSpace = rawFormular.replaceAll(" ", "");

        initOperands(formularWithoutSpace);
        initOperators(formularWithoutSpace);
    }

    private void initOperands(String formularWithoutSpace) {
        Queue<Operand> ops = new LinkedList<Operand>();
        for (String op : formularWithoutSpace.split(OPERATOR_PATTERN)) {
            ops.add(new Operand(op));
        }
        this.operands = ops;
    }

    private void initOperators(String formularWithoutSpace) {
        Queue<Operator> opts = new LinkedList<Operator>();
        String [] operatorArr = formularWithoutSpace.split(NUMBER_PATTERN);
        for (int i = 1; i < operatorArr.length; i++) {
            opts.add(new Operator(operatorArr[i]));
        }
        this.operators = opts;
    }

    public Operand getNextOperand() {
        return operands.remove();
    }

    public Operator getNextOperator() {
        return operators.remove();
    }

    public boolean hasOperand() {
        return !operands.isEmpty();
    }
}