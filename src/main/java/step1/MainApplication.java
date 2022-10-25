package step1;

import step1.controller.CalculatorController;
import step1.view.InputView;
import step1.view.OutputView;

import java.util.Scanner;

public class MainApplication {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		InputView inputView = new InputView(scanner);
		OutputView outputView = new OutputView();
		CalculatorController controller = new CalculatorController(inputView.getOperation());
		outputView.printResult(controller.calculating());
	}
}
