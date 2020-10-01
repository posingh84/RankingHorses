package se.atg.service.harrykart.request;

import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DeSerializationTest {

    @Test
    public void should_deserialize_successfully() throws Exception {

        JAXBContext context = JAXBContext.newInstance(HarryKart.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        HarryKart kart = (HarryKart)unmarshaller.unmarshal(this.getClass().getClassLoader().getResourceAsStream("input_0.xml"));

        assertTrue(kart != null);
        assertEquals(3, kart.getNumberOfLoops());
        assertEquals(4, kart.getStartList().size());
    }
}