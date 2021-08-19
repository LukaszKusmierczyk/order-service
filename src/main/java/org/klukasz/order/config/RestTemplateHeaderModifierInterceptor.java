package org.klukasz.order.config;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

public class RestTemplateHeaderModifierInterceptor implements ClientHttpRequestInterceptor {
    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
            throws IOException {

        System.out.println("INTERCEPT REST CALL");

        ClientHttpResponse response = execution.execute(request, body);

        for(String headerKey : request.getHeaders().keySet()) {
            System.out.println("REQUEST: " + headerKey);

            if(headerKey.startsWith("x-")) {
                System.out.println("ADDING: " + headerKey);
                response.getHeaders().add(headerKey, request.getHeaders().getFirst(headerKey));
            }
        }

        return response;
    }
}
