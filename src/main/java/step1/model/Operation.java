package step1.model;

public class Operation {
	public String operation;

	public Operation(String operation) {
		checkInputOperation(operation);
		this.operation = operation;
	}

	public void checkInputOperation(String operation){
		if(operation.isEmpty()) throw new IllegalArgumentException("입력연산은 적어도 한글자 이상이어야 합니다.");
		// TODO: 추가로 글자를 나눴을 때, 연산이 두 번 연속되거나 하는 경우에도 exception throw
	}
}
