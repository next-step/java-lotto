package step1;

import step1.controller.CalculatorController;
import step1.view.input.InputView;
import step1.view.input.InputViewImpl;
import step1.view.output.OutputView;
import step1.view.output.OutputViewImpl;

import java.util.Scanner;

public class MainApplication {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		InputView inputView = new InputViewImpl(scanner);
		OutputView outputView = new OutputViewImpl();
		CalculatorController controller = new CalculatorController(inputView.getOperation());
		outputView.printResult(controller.calculating());
	}
}
