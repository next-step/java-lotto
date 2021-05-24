package type;

public enum DecimalType {

	PLACE_TWO(2),
	;

	private int scale;

	DecimalType(final int scale){
		this.scale = scale;
	}

	public int value(){
		return this.scale;
	}
}
