package type;

public enum DecimalType {

	PLACE_TWO(100.0),
	;

	private double decimalReferenceValue;

	DecimalType(final double decimalReferenceValue){
		this.decimalReferenceValue = decimalReferenceValue;
	}

	public double value(){
		return this.decimalReferenceValue;
	}
}
