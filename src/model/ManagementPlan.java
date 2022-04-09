package model;

public class ManagementPlan {
	private double percent;
	private String description;

	public ManagementPlan(double percent, String description) {
		this.percent = percent;
		this.description = description;
	}

	public double getPercent() {
		return percent;
	}

	public String getDescription() {
		return description;
	}

	public void setPercent(double newPercent) {
		percent = newPercent;
	}

	public void setDescription(String newDescription) {
		description = newDescription;
	}
}