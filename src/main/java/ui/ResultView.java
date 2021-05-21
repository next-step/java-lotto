package ui;

import exception.LottoException;
import utils.ConsoleUtils;

public class ResultView {

	public static void printExceptionMessage(LottoException lottoException){
		ConsoleUtils.printLine(lottoException.getMessage());
	}

	public static void printMessage(final String message){
		ConsoleUtils.printLine(message);
	}

	public static void printMessageWithoutLine(final String message){
		ConsoleUtils.print(message);
	}

	public static void printLine(){
		ConsoleUtils.printLine();
	}
}
