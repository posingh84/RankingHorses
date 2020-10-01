package se.atg.service.harrykart.service;

import org.springframework.stereotype.Service;
import se.atg.service.harrykart.request.HarryKart;
import se.atg.service.harrykart.request.Lane;
import se.atg.service.harrykart.request.Loop;
import se.atg.service.harrykart.request.Participant;
import se.atg.service.harrykart.response.Ranking;
import se.atg.service.harrykart.response.RankingResponse;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class HarryKartService {

    private static final int LANE_DIMENSION = 1000;
    private static final int TOTAL_RANKS_TO_DISPLAY = 3;


    public RankingResponse rankHorses(final HarryKart harryKart) {

        List<Participant> participants = harryKart.getStartList();
        setTimeTakenFirstLoop(participants);

        calculateTimeTakenForAllLoops(harryKart.getPowerUps(), participants);

        participants = participants.stream()
                                .sorted(Comparator.comparing(Participant::getTimeTaken))
                                .collect(Collectors.toList());

        return buildResponse(participants);
    }

    private void setTimeTakenFirstLoop(final List<Participant> participants) {

        participants.forEach(participant -> participant.setTimeTaken(LANE_DIMENSION / participant.getBaseSpeed()));
    }


    private RankingResponse buildResponse(final List<Participant> participants) {

        List<Ranking> rankings = IntStream.range(0, participants.size())
                .mapToObj(index -> buildRanking(index, participants.get(index)))
                .limit(TOTAL_RANKS_TO_DISPLAY)
                .collect(Collectors.toList());

        return new RankingResponse(rankings);
    }

    private Ranking buildRanking(final int rank, final Participant participant) {

        return new Ranking(rank + 1, participant.getName());
    }

    private void calculateTimeTakenForAllLoops(final List<Loop> loops, final List<Participant> participants) {

        loops.forEach(loop -> calculateBaseSpeedEndOfLoop(participants, loop));
    }

    private void calculateBaseSpeedEndOfLoop(final List<Participant> participants, final Loop loop) {

        loop.getLane().forEach(currentLane -> {
            Participant participant = obtainParticipant(participants, currentLane);
            int currentBaseSpeed = currentLane.getValue() + participant.getBaseSpeed();
            participant.setTimeTaken(participant.getTimeTaken() + (LANE_DIMENSION / currentBaseSpeed));
            participant.setBaseSpeed(currentBaseSpeed);
        });
    }

    private Participant obtainParticipant(final List<Participant> participants, final Lane currentLane) {
         return participants.stream()
                .filter(p -> p.getLane() == currentLane.getNumber())
                .collect(Collectors.toList()).get(0);
    }
}
