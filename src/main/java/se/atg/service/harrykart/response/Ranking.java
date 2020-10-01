package se.atg.service.harrykart.response;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

@JsonAutoDetect(fieldVisibility= JsonAutoDetect.Visibility.ANY)
public class Ranking {

    @JsonProperty("position")
    private int position;

    @JsonProperty("horse")
    private final String horseName;

    @JsonCreator
    public Ranking(@JsonProperty("position")final int position,
                   @JsonProperty("horse")final String name)
    {
        this.position=position;
        this.horseName=name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ranking ranking = (Ranking) o;

        if (position != ranking.position) return false;
        return Objects.equals(horseName, ranking.horseName);
    }

    @Override
    public int hashCode() {
        int result = position;
        result = 31 * result + (horseName != null ? horseName.hashCode() : 0);
        return result;
    }
}
