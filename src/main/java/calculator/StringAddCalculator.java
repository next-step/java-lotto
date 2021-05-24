package calculator;

public class StringAddCalculator {

	private Input input;

	public StringAddCalculator(String userInput) {
		this.input = new Input(userInput);
	}

	public int splitAndSum() {
		if(input.isEmpty()) {
			return 0;
		}

		String[] tokens = new Tokenizer(input).split();
		Numbers numbers = new Numbers(tokens);
		return numbers.sum();
	}
}
