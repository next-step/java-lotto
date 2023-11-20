package step1;

import java.util.List;

public class StringCalculator {

    private final List<String> tokens;

    public StringCalculator(List<String> tokens) {
        this.tokens = tokens;
    }

    public int calculate() {

        Status status = new Status(0, 0);

        while(status.index < tokens.size()) {
            String token  = tokens.get(status.index);
            processToken(token, status);
        }

        return status.result;
    }

    private void processToken(String token, Status status) {
        if(Operand.isOperand(token)) {
            status.result = Operand.operand(token);
            status.index++;
            return;
        }
        processOperator(token, status);
    }


    private void processOperator(String token, Status status) {

        int result = status.result;
        status.index++;

        String nextToken = tokens.get(status.index);
        status.result = new Operator(token).calculate(result, Operand.operand(nextToken));
        status.index++;
    }

    static class Status {
    	private int index;
    	private int result;

    	public Status(int index, int result) {
    		this.index = index;
    		this.result = result;
    	}
    }
}
