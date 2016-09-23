
public class Cards {
	
	private int score;
	private String imageCard;
	
	
	public String getImageCard() {
		return imageCard;
	}
	public void setImageCard(String imageCard) {
		this.imageCard = imageCard;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public Cards(int score, String imageCard) {
		super();
		this.score = score;
		this.imageCard = imageCard;
	}
	@Override
	public String toString() {
		return "[Очки=" + score +  ", Картинка=" + imageCard + "]";
	}	
}
