package com.example.Rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

@RestController
@RequestMapping("/rest")
public class AppController {

	@GetMapping("/done")
	public String getMethod(){
		String output = "";
		try {

			Client client = Client.create();

			WebResource webResource = client
			   .resource("http://springboot-openshift002-springboot-openshift001.apps.na39.openshift.opentlc.com/app/service");

			ClientResponse response = webResource.accept("application/json")
	                   .get(ClientResponse.class);

			if (response.getStatus() != 200) {
			   throw new RuntimeException("Failed : HTTP error code : "
				+ response.getStatus());
			}

			output = response.getEntity(String.class);

			System.out.println("Output from Server .... \n");
			System.out.println(output);

		  } catch (Exception e) {

			e.printStackTrace();

		  }
		return "Well Done ... calling second app .."+output;
	}
}
