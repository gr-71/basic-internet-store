package com.rga.springwebapp.endpoints;

import com.rga.springwebapp.services.ProductService;
import com.rga.springwebapp.ws.products.GetProductRequest;
import com.rga.springwebapp.ws.products.GetProductResponse;
import com.rga.springwebapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.xml.datatype.DatatypeConfigurationException;

@Endpoint
public class ProductsEndpoint {

    private static final String NAMESPACE_URI = "http://com.rga.springwebapp.ws.products";

    @Autowired
    private ProductService productService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getProductRequest")
    @ResponsePayload
    public GetProductResponse getProduct(@RequestPayload GetProductRequest request) throws DatatypeConfigurationException {
        GetProductResponse response = new GetProductResponse();
        response.setProduct(productService.getProduct(request.getTitle()));
        return response;
    }
}
