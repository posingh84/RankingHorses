package se.atg.service.harrykart.response;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RankingResponse {

    @JsonProperty("ranking")
    private final List<Ranking> ranking;

    @JsonCreator
    public RankingResponse(@JsonProperty("ranking")final List<Ranking> ranking) {

        this.ranking = ranking;
    }

    public List<Ranking> getRanking() {
        return ranking;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RankingResponse that = (RankingResponse) o;

        return ranking.equals(that.ranking);
    }

    @Override
    public int hashCode() {
        return ranking.hashCode();
    }

}
