package lotto.exceptions;

public class DuplicationNotAllowedException extends RuntimeException {
	public DuplicationNotAllowedException() {
		super("로또번호는 중복될 수 없습니다");
	}
}
