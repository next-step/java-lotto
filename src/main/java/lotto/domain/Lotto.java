package lotto.domain;

public enum Lotto {
	ONE(new Digit(1)),
	TWO(new Digit(2)),
	THREE(new Digit(3)),
	FOUR(new Digit(4)),
	FIVE(new Digit(5)),
	SIX(new Digit(6)),
	SEVEN(new Digit(7)),
	EIGHT(new Digit(8)),
	NINE(new Digit(9)),
	TEN(new Digit(10)),
	ELEVEN(new Digit(11)),
	TWELVE(new Digit(12)),
	THIRTEEN(new Digit(13)),
	FOURTEEN(new Digit(14)),
	FIFTEEN(new Digit(15)),
	SIXTEEN(new Digit(16)),
	SEVENTEEN(new Digit(17)),
	EIGHTEEN(new Digit(18)),
	NINETEEN(new Digit(19)),
	TWENTY(new Digit(20)),
	TWENTYONE(new Digit(21)),
	TWENTYTWO(new Digit(22)),
	TWENTYTHREE(new Digit(23)),
	TWENTYFOUR(new Digit(24)),
	TWENTYFIVE(new Digit(25)),
	TWENTYSIX(new Digit(26)),
	TWENTYSEVEN(new Digit(27)),
	TWENTYEIGHT(new Digit(28)),
	TWENTYNINESIX(new Digit(29)),
	THIRTY(new Digit(30)),
	THIRTYONE(new Digit(31)),
	THIRTYTWO(new Digit(32)),
	THIRTYTREE(new Digit(33)),
	THIRTYFOUR(new Digit(34)),
	THIRTYFIVE(new Digit(35)),
	THIRTYSIX(new Digit(36)),
	THIRTYSEVEN(new Digit(37)),
	THIRTYEIGHT(new Digit(38)),
	THIRTYNINE(new Digit(39)),
	FOURTY(new Digit(40)),
	FOURTYONE(new Digit(41)),
	FOURTYTWO(new Digit(42)),
	FOURTYTHREE(new Digit(43)),
	FOURTYFOUR(new Digit(44)),
	FOURTYFIVE(new Digit(45));

	private final lotto.domain.Digit value;

	Lotto(Digit value) {

		this.value = value;
	}

	public boolean isBetween(Digit start, Digit end) {
		return value.compareTo(start) && end.compareTo(value);
	}

	public boolean equalTo(final Digit digit) {
		return value.equals(digit);
	}
}
