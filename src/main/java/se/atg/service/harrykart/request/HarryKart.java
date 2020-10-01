package se.atg.service.harrykart.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "harryKart")
@XmlAccessorType(XmlAccessType.FIELD)
public class HarryKart {

    @XmlElement
    private int numberOfLoops;

    @XmlElementWrapper(name = "startList")
    @XmlElement(name = "participant")
    private List<Participant> startList;

    @XmlElementWrapper(name = "powerUps")
    @XmlElement(name = "loop")
    private List<Loop> powerUps;

    public List<Loop> getPowerUps() {
        return powerUps;
    }

    public void setPowerUps(List<Loop> powerUps) {
        this.powerUps = powerUps;
    }

    public int getNumberOfLoops() {
        return numberOfLoops;
    }

    public void setNumberOfLoops(int numberOfLoops) {
        this.numberOfLoops = numberOfLoops;
    }

    public List<Participant> getStartList() {
        return startList;
    }

    public void setStartList(List<Participant> startList) {
        this.startList = startList;
    }
}
