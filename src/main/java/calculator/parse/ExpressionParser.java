package calculator.parse;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ExpressionParser {

    private String firstOperand;
    private String secondOperand;
    private String operator;
    private Queue<String> queue = new LinkedList<>();

    public String[] parse(String expression){
        if( (expression == null) || (expression.isEmpty()) ){
            throw new IllegalArgumentException();
        }

        String[] expressionElements = expression.split(" ");
        queue.addAll(List.of(expressionElements));
        return expressionElements;
    }

    public void setFirstOperand(int firstOperand){
        this.firstOperand = Integer.toString(firstOperand);
    }

    public boolean isEmpty(){
        return this.queue.isEmpty();
    }

    public String[] next()  {
        if(this.isEmpty()){
            return null;
        }

        if(this.firstOperand == null){
            this.firstOperand = this.queue.poll();
        }

        if(this.operator == null){
            this.operator = this.queue.poll();
        }

        if(this.secondOperand == null){
            this.secondOperand = this.queue.poll();
        }

        String[] exp = new String[]{this.firstOperand, this.operator, this.secondOperand};

        this.firstOperand = null;
        this.operator = null;
        this.secondOperand = null;

        return exp;
    }
}
