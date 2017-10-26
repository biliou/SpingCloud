package com.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.example.Producer1Application;
import com.example.controller.MainController;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Producer1Application.class)
public class MainControllerTests {

	private MockMvc mvc;

	@Before
	public void Setup() throws Exception {
		mvc = MockMvcBuilders.standaloneSetup(new MainController()).build();
	}

	@Test
	public void testHello() throws Exception {
			MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.get("/hello");
			mockHttpServletRequestBuilder.param("name", "tom");

			ResultActions resultActions = mvc.perform(mockHttpServletRequestBuilder); // 执行请求
			resultActions.andDo(MockMvcResultHandlers.print()); // 添加ResultHandler结果处理器，比如调试时打印结果到控制台；

			resultActions.andExpect(status().isOk()); // 添加ResultMatcher验证规则，验证控制器执行完成后结果是否正确；
			resultActions.andExpect(content().string(equalTo("SUCCESS1")));
	}

}
