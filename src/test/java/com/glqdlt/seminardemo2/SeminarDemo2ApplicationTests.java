package com.glqdlt.seminardemo2;

import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashMap;
import java.util.Map;

@WebAppConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest
public class SeminarDemo2ApplicationTests {

	private static final Logger log = LoggerFactory.getLogger(SeminarDemo2ApplicationTests.class);

	private MockMvc mockMvc;

	@Autowired
	@InjectMocks
	private RestApiController restApiController;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(restApiController).build();
	}


	@Test
	public void contextLoads() {

	}

	@Test
	public void testApiGreeting() throws Exception {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("message","jhun");
		String data = jsonObject.toString();
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/api/greeting").contentType(MediaType.APPLICATION_JSON).content(data))
				.andReturn();

		Assert.assertEquals(result.getResponse().getContentAsString(),"NIce to Meet You jhun");
	}
}
