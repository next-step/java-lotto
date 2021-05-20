public class SperatedText {

	private String sperator;
	private String texts;


	public SperatedText(final String sperator, final String texts){
		this.sperator = sperator;
		this.texts = texts;
	}

	public String getSperator(){
		return this.sperator;
	}

	public String getTexts(){
		return this.texts;
	}
}
