package calculator.parse;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ExpressionParser {

    private String a;
    private String b;
    private String op;
    private Queue<String> queue = new LinkedList<>();

    public String[] parse(String expression){
        String[] expressionElements = expression.split(" ");
        queue.addAll(List.of(expressionElements));
        return expressionElements;
    }

    public String[] next(){
        if(this.a == null){
            this.a = this.queue.poll();
        }

        if(this.op == null){
            this.op = this.queue.poll();
        }

        if(this.b == null){
            this.b = this.queue.poll();
        }

        return new String[]{this.a, this.op, this.b};
    }
}
