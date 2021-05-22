package calculator;

public class StringAddCalculator {

	private Input input;
	private Numbers numbers;

	public StringAddCalculator(String userInput) {
		this.input = new Input(userInput);
		this.numbers = new Numbers();
	}

	public int splitAndSum() {
		if(input.isEmpty()) {
			return 0;
		}

		String[] tokens = new Tokenizer(input).split();

		for(String token : tokens) {
			numbers.add(new Number(token));
		}
		return numbers.sum();
	}
}
