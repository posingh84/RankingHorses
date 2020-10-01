package se.atg.service.harrykart.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import se.atg.service.harrykart.request.HarryKart;
import se.atg.service.harrykart.response.RankingResponse;
import se.atg.service.harrykart.service.HarryKartService;

import java.util.Optional;

@RestController
@Api(tags = "HarryKart Ranking System")
public class HarryKartController {

    private static final String BASE_URL = "/api/play";

    @Autowired
    private  HarryKartService service;

    public HarryKartController(final HarryKartService service) {

        this.service = service;
    }

    @ApiOperation(value = "Returns the Top 3 fastest participating horses",
            httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ranking Calculated successfully"),
            @ApiResponse(code = 400, message = "Bad request")
    })
    @PostMapping(path = BASE_URL, consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RankingResponse> playHarryKart(@ApiParam(value = "XML request payload consisting of participating horses and the lane powerups")
                                                             @RequestBody HarryKart harryKart) {

        if(!Optional.ofNullable(harryKart).isPresent())
            new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        return ResponseEntity.ok()
                .body(service.rankHorses(harryKart));
    }
}
