package domain;

public class LottoGame {

	public static void main(String[] args) {

		Input input = new Input();
		Result result = new Result();
		LottoNumberGenerator generator = new LottoNumberGenerator();
		input.setAccount();
		result.viewResult();
		generator.getLottoNumber();
	}
}
