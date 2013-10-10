package com.eventshop.server;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.eventshop.backend.Emage;
import com.eventshop.backend.StreamHandlerSingleton;
import com.google.gson.Gson;

/**
 * Root resource (exposed at "emage" path)
 */
@Path("emage")
public class EmageResource {
	
    private static final String EMAGE_NOT_FOUND_ERROR = "Emage not found or inacessible";

	/**
     * Method handling HTTP GET requests for emages
     *
     * @return String Requested emage or an error message.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getMostRecentEmage(@QueryParam("pipeline_id") int pipeline_id) {
    	System.out.println("Here!");
		try {
			Gson gson = new Gson();
			Emage emage = StreamHandlerSingleton.getInstance().getLatestEmageByPipelineID(pipeline_id);
			return gson.toJson(emage);
		} catch (Exception e) {
			e.printStackTrace();
			return EMAGE_NOT_FOUND_ERROR;
		}
    }
}
