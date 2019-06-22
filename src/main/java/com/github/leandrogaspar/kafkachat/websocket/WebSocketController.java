package com.github.leandrogaspar.kafkachat.websocket;

import com.github.leandrogaspar.kafkachat.model.Login;
import com.github.leandrogaspar.kafkachat.model.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {

    private static final Logger logger = LoggerFactory.getLogger(WebSocketController.class);

    @MessageMapping("/login")
    @SendToUser("/queue/response")
    public Response login(Login login) {
        logger.info("User trying to login with username " + login.getUsername());

        return new Response("You are logged on " + login.getUsername());
    }
}
