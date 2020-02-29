public class DonationPackage {
	
	private String description;
	private double weight;
	
	public DonationPackage(String description, double pWeight) {
		
		this.description = description;
		this.weight = pWeight;
	}
	
	
	public DonationPackage() {
		
	}

	public String getDescription() {
		
		return description;
	}
	
	public void setDescription(String description) {
		
		this.description = description;
	}
	
	public double getWeight() {
		
		return weight;
	}
	
	public void setWeight(int weight) {
		
		this.weight = weight;
	}


	public boolean isHeavy() {
		
		if(weight > 20)
			return true;
		
		else
			return false;
	}
}
