package com.eventshop.server;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.eventshop.backend.STTPoint;
import com.eventshop.backend.StreamHandlerSingleton;
import com.google.gson.Gson;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("points")
public class PointResource {

	private static final String GET_POINTS_ERROR_MSG = "Points not found or inacessible";

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getMostRecentPoints(@QueryParam("pipeline_id") int pipeline_id) {
		try {
			ArrayList<STTPoint> points = StreamHandlerSingleton.getInstance().getLatestPointsByPipelineID(pipeline_id);
			Gson gson = new Gson();
			return gson.toJson(points);
		} catch (Exception e) {
			return GET_POINTS_ERROR_MSG;
		}
	}
}
