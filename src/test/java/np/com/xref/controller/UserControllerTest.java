package np.com.xref.controller;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.unauthenticated;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

import np.com.xref.service.UserService;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@WithMockUser
public class UserControllerTest {

	@Autowired
	private WebApplicationContext context;

	private MockMvc mvc;

	@MockBean
	private UserService service;

	@Autowired
	private ObjectMapper objectMapper;

	@Before
	public void setUp() throws Exception {
		mvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	// @WithMockUser(username = "admin", roles = { "USER", "ADMIN" })
	@Test
	public void getCurrentUser_shouldSucceedWith200() throws Exception {
		mvc.perform(get("/api/users/me").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}

	@Test
	public void getHello_shouldSucceedWith200() throws Exception {
		mvc.perform(get("/api/users/hello").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}

	@Test
    @WithAnonymousUser
    public void getCurrentUser_anonymous() throws Exception {
		mvc.perform(get("/api/users/me").contentType(MediaType.APPLICATION_JSON)).andExpect(unauthenticated());
		    
    }

}
