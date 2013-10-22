package com.eventshop.server;

import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;

public class EventshopService extends Service<EventshopConfiguration> {
	public static void main(String[] args) throws Exception {
		new EventshopService().run(args);
	}
	
	@Override
	public void initialize(Bootstrap<EventshopConfiguration> bootstrap) {
		
	}
	
	@Override
	public void run(EventshopConfiguration configuration, Environment environment) {
		environment.addResource(new MyResource());
		environment.addResource(new EmageResource());
		environment.addResource(new PointResource());
	}
}
