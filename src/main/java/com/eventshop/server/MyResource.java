package com.eventshop.server;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.eventshop.backend.StreamHandler;
import com.eventshop.backend.StreamHandlerSingleton;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("pipeline")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
    	
        return "Current ID" + StreamHandlerSingleton.getInstance().currentPipelineCount;
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    //@Produces(MediaType.APPLICATION_JSON)
    public Response createDataSource(
    		@FormParam("NWlat") double NWlat,
				@FormParam("NWlong") double NWlong,
				@FormParam("SElat") double SElat,
				@FormParam("SElong") double SElong,
				@FormParam("resolutionX") double resolutionX, 
				@FormParam("resolutionY") double resolutionY,
				@FormParam("source") String source,
				@FormParam("theme") String theme,
				@FormParam("wrapperType") String wrapperType,
				@FormParam("operatorType") String operatorType,
				@FormParam("pointPollingRateMS") int pointPollingRateMS,
				@FormParam("emageCreationRateMS") int emageCreationRateMS,
				@FormParam("emageWindowLength") int emageWindowLength
				) {
    	
    	StreamHandler s = StreamHandlerSingleton.getInstance();
    	int pipeline_id = s.buildAndStartNewPipeline(NWlat, NWlong, SElat, SElong, resolutionX, resolutionY,
    			source, theme, wrapperType, operatorType, pointPollingRateMS, emageCreationRateMS,
    			emageWindowLength, "", "","","");
    	return Response.status(200).entity("{pipeline_id:"+pipeline_id+"}").build();
    
    }
}
