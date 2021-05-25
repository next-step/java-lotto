package lotto.io.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import lotto.io.domain.vo.InputText;
import lotto.io.exception.IllegalInputTextException;

public class InputOutputUtil {
	private InputStreamReader inputStreamReader = new InputStreamReader(System.in);
	private BufferedReader bufferedReader = new BufferedReader(this.inputStreamReader);

	public InputText readLineFromSystemIn() throws IOException, IllegalInputTextException {
		String systemInText = this.bufferedReader.readLine().trim();
		return InputText.generate(systemInText);
	}
}
