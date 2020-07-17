package convertion;

public class AlienNumber {
	
	private String alienNumbers;
	private Double silverInterestellar;
	private Double goldInterestellar;
	private Double platinumInterestellar;
	
	AlienNumber(String alienNumbers, Double SilverInterestellar, Double GoldInterestellar, Double PlatinumInterestellar){
		this.alienNumbers = alienNumbers;
		this.silverInterestellar = SilverInterestellar;
		this.goldInterestellar = GoldInterestellar;
		this.platinumInterestellar = PlatinumInterestellar;
	}
	
	String getAlienNumbers() {
		return alienNumbers;
	}
	
	void setAlienNumbers (String alienNumbers) {
		this.alienNumbers = alienNumbers;
	}
	
	Double getSilverInterestellar() {
		return silverInterestellar;
	}
	
	void setSilverInterestellar(Double silverInterestellar) {
		this.silverInterestellar = silverInterestellar;
	}
	
	Double getGoldInterestellar() {
		return goldInterestellar;
	}
	
	void setGoldInterestellar(Double goldInterestellar) {
		this.goldInterestellar = goldInterestellar;
	}
	
	Double getPlatinumInterestellar() {
		return platinumInterestellar;
	}
	
	void setPlatinumInterestellar (Double platinumInterestellar) {
		this.platinumInterestellar = platinumInterestellar;
	}
	
}
