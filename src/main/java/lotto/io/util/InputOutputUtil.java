package lotto.io.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import lotto.io.domain.vo.InputText;
import lotto.io.exception.UnexpectedInputOutputRuntimeException;

public class InputOutputUtil {
	private final InputStreamReader inputStreamReader = new InputStreamReader(System.in);
	private final BufferedReader bufferedReader = new BufferedReader(this.inputStreamReader);

	public InputText readLineFromSystemIn() {
		try {
			String systemInText = this.bufferedReader.readLine().trim();
			return InputText.generate(systemInText);
		} catch (IOException e) {
			e.printStackTrace();
			throw new UnexpectedInputOutputRuntimeException("예측할 수 없는 'I/O Exception'이 발생했습니다. 로또 애플리케이션을 다시 실행해주세요.");
		}
	}
}
