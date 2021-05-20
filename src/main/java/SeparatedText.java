public class SeparatedText {

	private String delimiter;
	private String texts;


	public SeparatedText(final String delimiter, final String texts){
		this.delimiter = delimiter;
		this.texts = texts;
	}

	public String getDelimiter(){
		return this.delimiter;
	}

	public String getTexts(){
		return this.texts;
	}
}
