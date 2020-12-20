package com.shadrachjabonir;

import io.quarkus.vertx.web.Route;
import io.quarkus.vertx.web.RoutingExchange;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.json.JsonObject;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
public class GreetingResource {

    @Route(path = "/greetings", methods = HttpMethod.GET, produces = MediaType.APPLICATION_JSON)
    void greetings(RoutingExchange ex) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.put("hello",ex.getParam("name").orElse("world"));
        ex.ok(jsonObject.toString());
    }
}