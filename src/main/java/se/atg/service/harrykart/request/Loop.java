package se.atg.service.harrykart.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name="loop")
@XmlAccessorType(XmlAccessType.FIELD)
public class Loop {

	@XmlAttribute
	private int number;
	
	@XmlElement(name="lane")
	private List<Lane> lane;
	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public List<Lane> getLane() {
		return lane;
	}

	public void setLane(List<Lane> lane) {
		this.lane = lane;
	}

}
