package com.samplesoap.demo;

import hello.wsdl.GetCountryRequest;
import hello.wsdl.GetCountryResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class CountriesClient extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(CountriesClient.class);


    public GetCountryResponse getCountryResponse(String countryName) {

        GetCountryRequest country = new GetCountryRequest();
        country.setName(countryName);

        log.info("Requesting country information " + countryName);

        GetCountryResponse response = (GetCountryResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/ws", country,
                        new SoapActionCallback("http://localhost:8080/ws"));

        return response;


    }



}
