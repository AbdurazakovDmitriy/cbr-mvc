package com.currencyrate.mvc.mapper;

import com.currencyrate.mvc.model.ValCurs;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.stereotype.Component;

@Component
public class RatesMapper {

    public ValCurs toValcursFromString(String source) {
        XmlMapper xmlMapper = new XmlMapper();
        try {
            return xmlMapper.readValue(source, ValCurs.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("could not parse from: " + source);
        }
    }
}
