package se.atg.service.harrykart.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "participant")
@XmlAccessorType(XmlAccessType.FIELD)

public class Participant {

	@XmlElement
	private int lane;

	@XmlElement
	private String name;

	@XmlElement
	private int baseSpeed;

	private double timeTaken;

	public double getTimeTaken() {
		return timeTaken;
	}

	public void setTimeTaken(double timeTaken) {
		this.timeTaken = timeTaken;
	}

	public int getLane() {
		return lane;
	}

	public void setLane(int lane) {
		this.lane = lane;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBaseSpeed() {
		return baseSpeed;
	}

	public void setBaseSpeed(int baseSpeed) {
		this.baseSpeed = baseSpeed;
	}

}
