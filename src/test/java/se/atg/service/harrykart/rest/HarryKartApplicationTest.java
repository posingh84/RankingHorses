package se.atg.service.harrykart.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import se.atg.service.harrykart.HarryKartTest;
import se.atg.service.harrykart.response.Ranking;
import se.atg.service.harrykart.response.RankingResponse;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class HarryKartApplicationTest extends HarryKartTest {

    private static final String URL_PATH = "/api/play";

    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
    public void testWithInputFile_1() throws Exception {

        final String xmlString = getFileContent("input_0.xml");

        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.post(URL_PATH).contentType(MediaType.APPLICATION_XML_VALUE).content(xmlString))
                .andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);

        RankingResponse computedResult = new ObjectMapper().readValue(mvcResult.getResponse().getContentAsString(), RankingResponse.class);
        RankingResponse expectedResult = new RankingResponse(new ArrayList<>());
        expectedResult.getRanking().add(new Ranking(1, "TIMETOBELUCKY"));
        expectedResult.getRanking().add(new Ranking(2, "HERCULES BOKO"));
        expectedResult.getRanking().add(new Ranking(3, "CARGO DOOR"));

        assertEquals(3, computedResult.getRanking().size());
        assertEquals(computedResult, expectedResult);
    }

    @Test
    public void testWithInputFile_2() throws Exception {

        String xmlString = getFileContent("input_1.xml");

        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.post(URL_PATH).contentType(MediaType.APPLICATION_XML_VALUE).content(xmlString))
                .andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);

        RankingResponse computedResult = new ObjectMapper().readValue(mvcResult.getResponse().getContentAsString(), RankingResponse.class);
        RankingResponse expectedResult = new RankingResponse(new ArrayList<>());
        expectedResult.getRanking().add(new Ranking(1, "WAIKIKI SILVIO"));
        expectedResult.getRanking().add(new Ranking(2, "TIMETOBELUCKY"));
        expectedResult.getRanking().add(new Ranking(3, "HERCULES BOKO"));

        assertEquals(3, computedResult.getRanking().size());
        assertEquals(computedResult, expectedResult);
    }

    private String getFileContent(final String fileName) throws URISyntaxException, IOException {

        return new String(Files.readAllBytes(Paths.get(this.getClass().getClassLoader().getResource(fileName).toURI())));
    }
}
