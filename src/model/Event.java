package model;

public class Event {
	private EventType type;
	private String organizer;
	private double cost;
	private String description;
	private Date eventDate;

	public Event(EventType type, String organizer, double cost, String description, Date eventDate) {
		this.type = type;
		this.organizer = organizer;
		this.cost = cost;
		this.description = description;
		this.eventDate = eventDate;
	}

	public int numMaintenance() {
		int yearEvent = eventDate.getYear();
		return yearEvent;
	}

	public EventType getType() {
		return type;
	}

	public String getOrganizer() {
		return organizer;
	}

	public double getCost() {
		return cost;
	}

	public String getDescription() {
		return description;
	}

	public Date getEventDate() {
		return eventDate;
	}

	public void setType(EventType newType) {
		type = newType;
	}

	public void setOrganizer(String newOrganizer) {
		organizer = newOrganizer;
	}

	public void setCost(double newCost) {
		cost = newCost;
	}

	public void setDescription(String newDescription) {
		description = newDescription;
	}

	public void setEventDate(Date newEventDate) {
		eventDate = newEventDate;
	}
}