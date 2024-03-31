package calculator.parse;

import calculator.calc.Calculator;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ExpressionParser {

    private String a;
    private String b;
    private String op;
    private Queue<String> queue = new LinkedList<>();

    public String[] parse(String expression){
        if( (expression == null) || (expression.isEmpty()) ){
            throw new IllegalArgumentException();
        }

        String[] expressionElements = expression.split(" ");
        queue.addAll(List.of(expressionElements));
        return expressionElements;
    }

    public void setA(int a){
        this.a = Integer.toString(a);
    }

    public boolean isEmpty(){
        return this.queue.isEmpty();
    }

    public String[] next()  {
        if(this.isEmpty()){
            return null;
        }

        if(this.a == null){
            this.a = this.queue.poll();
        }

        if(this.op == null){
            this.op = this.queue.poll();
        }

        if(this.b == null){
            this.b = this.queue.poll();
        }

        String[] exp = new String[]{this.a, this.op, this.b};

        this.a = null;
        this.op = null;
        this.b = null;

        return exp;
    }
}
