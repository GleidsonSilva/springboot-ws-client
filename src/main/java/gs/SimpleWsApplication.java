package gs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.socket.client.WebSocketConnectionManager;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;

import gs.ws.SimpleWsHandler;

/**
 * Sample application for understanding how does springboot can be used as a WS client.
 */
@SpringBootApplication
public class SimpleWsApplication {
	
	private final String webSocketUri = "wss://api.web.com/ws";

    public static void main(String[] args) {
        SpringApplication.run(SimpleWsApplication.class, args);
    }
    
    @Bean
    public WebSocketConnectionManager wsConnectionManager() {
    	
    	//Generates a web socket connection
    	WebSocketConnectionManager manager = new WebSocketConnectionManager(
    			new StandardWebSocketClient(),
    			new SimpleWsHandler(), //Must be defined to handle messages
    			this.webSocketUri);
    	
    	//Will connect as soon as possible
    	manager.setAutoStartup(true);
    	
    	return manager;
    }
}