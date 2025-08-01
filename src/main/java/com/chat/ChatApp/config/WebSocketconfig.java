package com.chat.ChatApp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketconfig implements WebSocketMessageBrokerConfigurer{

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // set a message broker
        registry.enableSimpleBroker("/topic"); // this is our broker which hadle messages so whoever is subscribe to /topic/examplechatroom can receive message

        // add a line to tell the server when to expect a request for message
        // like expect message with /app/sendmessage
        registry.setApplicationDestinationPrefixes("/app"); // tell the channel that if you get messsage with this prefix then process it

    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/chat")   // defining the end point for the web socket
            .setAllowedOrigins("http://localhost:9090")     // from where the request is come and also for security
            .withSockJS();  // it add compability for cliet who dont support websocket 
    }

    

}
